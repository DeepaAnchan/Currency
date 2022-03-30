drop table if exists currency_conversion_table; 
create table currency_conversion_table (country_code varchar(255) not null, conversion_factor double, primary key (country_code));