-- =============================================
-- Automatic Invoice Numbering System
-- =============================================

-- Control table for yearly sequence
CREATE TABLE invoice_sequence_control (
    year CHAR(2) PRIMARY KEY,
    last_value BIGINT NOT NULL DEFAULT 1
);

-- Enhanced generator function
CREATE OR REPLACE FUNCTION generate_invoice_number()
RETURNS TRIGGER AS $$
DECLARE
    current_year TEXT := TO_CHAR(NEW.invoice_date, 'YY');
    next_val BIGINT;
BEGIN
  IF NEW.invoice_number IS NULL THEN
    -- Lock to prevent concurrency issues
    LOCK TABLE invoice_sequence_control IN EXCLUSIVE MODE;

    -- Get or create yearly sequence
    INSERT INTO invoice_sequence_control (year, last_value)
    VALUES (current_year, 1)
    ON CONFLICT (year) DO UPDATE
    SET last_value = invoice_sequence_control.last_value + 1
    RETURNING last_value INTO next_val;

    -- Format: INV-YY-000001
    NEW.invoice_number := 'INV-' || current_year || '-' || LPAD(next_val::TEXT, 6, '0');
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create the trigger
CREATE TRIGGER set_invoice_number
BEFORE INSERT ON invoice
FOR EACH ROW
EXECUTE FUNCTION generate_invoice_number();
