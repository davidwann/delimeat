
-- Create table 'Categories'

CREATE TABLE Categories
(
   id               BIGINT       NOT NULL  GENERATED ALWAYS AS IDENTITY,  
   category         VARCHAR(10)  NOT NULL  DEFAULT '',
   category_desc    VARCHAR(50)  NOT NULL  DEFAULT '',
   parent_category  VARCHAR(50)  NOT NULL  DEFAULT '',
   PRIMARY KEY (id)
);

-- Create an index

CREATE UNIQUE INDEX idx_Categories_category
   ON Categories ( category );

-- -------------------------------------------------------- --

-- Create table 'Cities'

CREATE TABLE Cities
(
   id            BIGINT        NOT NULL  GENERATED ALWAYS AS IDENTITY,
   city          VARCHAR(25)   NOT NULL  DEFAULT '',
   city_sector   VARCHAR(10)   NOT NULL  DEFAULT '',
   website       VARCHAR(50)   NOT NULL  DEFAULT '',
   website_type  VARCHAR(20)   NOT NULL  DEFAULT '',
   spam          VARCHAR(3)    NOT NULL  DEFAULT '',
   region        VARCHAR(100)  NOT NULL  DEFAULT '',
   PRIMARY KEY (id)
);


-- Create an index

CREATE UNIQUE INDEX idx_Cities_website_type_city_city_sector
   ON Cities ( website_type, city, city_sector );

-- -------------------------------------------------------- --

-- CREATE TABLE WebsiteRegions 

-- also load from cities.txt file 

CREATE TABLE WebsiteRegions 
(
   id            BIGINT        NOT NULL  GENERATED ALWAYS AS IDENTITY,
   website       VARCHAR(50)   NOT NULL  DEFAULT '',
   region        VARCHAR(100)  NOT NULL  DEFAULT '',
   PRIMARY KEY (id)
);

-- Create an index

CREATE UNIQUE INDEX idx_WebsiteRegions_website 
   ON WebsiteRegions ( website ); 

-- -------------------------------------------------------- --

-- Create table 'EmailAddresses'

CREATE TABLE EmailAddresses
(
   id              BIGINT        NOT NULL  GENERATED ALWAYS AS IDENTITY,
   email           VARCHAR(100)  NOT NULL  DEFAULT '',
   ad_url          VARCHAR(100)  NOT NULL  DEFAULT '',
   ad_date         DATE          NOT NULL  DEFAULT '1900-01-01',
   contacted       BOOLEAN       NOT NULL  DEFAULT FALSE,
   city            VARCHAR(25)   NOT NULL  DEFAULT '',
   city_sector     VARCHAR(10)   NOT NULL  DEFAULT '',
   cl_ad_category  VARCHAR(10)   NOT NULL  DEFAULT '',
   website         VARCHAR(50)   NOT NULL  DEFAULT '',
   website_type    VARCHAR(20)   NOT NULL  DEFAULT '',
   created         TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP,
   modified        TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (id)
);

-- Create index

CREATE UNIQUE INDEX idx_EmailAddresses_website_type_email 
   ON EmailAddresses ( website_type, email ); 

CREATE INDEX idx_EmailAddresses_contacted_created 
   ON EmailAddresses ( contacted, created ); 

-- -------------------------------------------------------- --

   
