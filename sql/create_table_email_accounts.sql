
-- create a database table
-- create_table_email_accounts.sql 
-- C:\Users\david_wann\workspace\JavaCLScrammer\sql\

CREATE TABLE email_accounts
(
   id                  INT  GENERATED ALWAYS AS IDENTITY, 
   email_address       VARCHAR(200)  NOT NULL  DEFAULT '', 
   smtp_server         VARCHAR(200)  NOT NULL  DEFAULT '', 
   port_number         SMALLINT      NOT NULL  DEFAULT 25, 
   email_local_part    VARCHAR(200)  NOT NULL  DEFAULT '', 
   email_domain_part   VARCHAR(200)  NOT NULL  DEFAULT '', 
   username            VARCHAR(200)  NOT NULL  DEFAULT '', 
   password            VARCHAR(200)  NOT NULL  DEFAULT '', 
   status              VARCHAR(20)   NOT NULL  DEFAULT 'untested', 
   is_used             CHAR(1)       NOT NULL  DEFAULT 'Y', 
   notes               LONG VARCHAR  NOT NULL  DEFAULT '', 
   PRIMARY KEY (id) 
);

CREATE UNIQUE INDEX idx_email_accounts_email_address  
   ON email_accounts (email_address); 

