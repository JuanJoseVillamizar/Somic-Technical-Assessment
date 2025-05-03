-- Table: clients
CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    tax_id VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    document VARCHAR(20) NOT NULL UNIQUE,
    credit_limit DECIMAL(12,2) NOT NULL,
    payment_terms INT NOT NULL
);

-- Table: products
CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    code VARCHAR(20) NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    lab VARCHAR(100) NOT NULL,
    stock INT NOT NULL,
    cost DECIMAL(12,2) NOT NULL,
    sale_price DECIMAL(12,2) NOT NULL
);

-- Table: Invoice
CREATE TABLE invoice (
    id SERIAL PRIMARY KEY,
    invoice_number VARCHAR(20) UNIQUE NOT NULL,
    invoice_date DATE NOT NULL,
    due_date DATE NOT NULL,
    client_id INTEGER NOT NULL,
    total_sale DECIMAL(12,2) NOT NULL,
    total_cost DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES Client(id)
);

-- Table: invoice_kardex
CREATE TABLE invoice_kardex (
    id SERIAL PRIMARY KEY,
    invoice_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    type CHAR(1) NOT NULL CHECK (type IN ('+', '-')),
    quantity INT NOT NULL,
    cost DECIMAL(12,2) NOT NULL,
    sale_price DECIMAL(12,2),
    line_total_sale DECIMAL(12,2) NOT NULL,
    line_total_cost DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES Invoice(id),
    FOREIGN KEY (product_id) REFERENCES Product(id)
);
