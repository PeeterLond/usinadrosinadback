-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-12 09:03:39.78

-- tables
-- Table: advertisement
CREATE TABLE advertisement (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    county_id int  NOT NULL,
    city_id int  NULL,
    tool_id int  NOT NULL,
    type_id int  NOT NULL,
    coordinate_id int  NULL,
    description varchar(2000)  NOT NULL,
    area int  NULL,
    price float(2)  NOT NULL,
    time timestamp  NOT NULL,
    CONSTRAINT advertisement_pk PRIMARY KEY (id)
);

-- Table: advertisement_chore
CREATE TABLE advertisement_chore (
    id serial  NOT NULL,
    chore_id int  NOT NULL,
    advertisement_id int  NOT NULL,
    CONSTRAINT advertisement_chore_pk PRIMARY KEY (id)
);

-- Table: chore
CREATE TABLE chore (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT chore_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
    id serial  NOT NULL,
    county_id int  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    county_id int  NOT NULL,
    city_id int  NULL,
    image_id int  NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    mobile_number varchar(50)  NULL,
    email varchar(50)  NOT NULL,
    introduction varchar(2000)  NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: coordinate
CREATE TABLE coordinate (
    id serial  NOT NULL,
    long decimal(9,6)  NOT NULL,
    lat decimal(9,6)  NOT NULL,
    CONSTRAINT coordinate_pk PRIMARY KEY (id)
);

-- Table: county
CREATE TABLE county (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT county_pk PRIMARY KEY (id)
);

-- Table: feedback
CREATE TABLE feedback (
    id serial  NOT NULL,
    receiver_user_id int  NOT NULL,
    rating int  NOT NULL,
    comment varchar(2000)  NULL,
    CONSTRAINT feedback_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
    id serial  NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: message
CREATE TABLE message (
    id serial  NOT NULL,
    letter_title varchar(255)  NOT NULL,
    letter_body varchar(2000)  NOT NULL,
    letter_time timestamp  NOT NULL,
    sender_user_id int  NOT NULL,
    receiver_user_id int  NOT NULL,
    is_read boolean  NOT NULL,
    CONSTRAINT message_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: tool
CREATE TABLE tool (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT tool_pk PRIMARY KEY (id)
);

-- Table: type
CREATE TABLE type (
    id serial  NOT NULL,
    name varchar(50)  NOT NULL,
    CONSTRAINT type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(50)  NOT NULL,
    password varchar(50)  NOT NULL,
    avg_rating float(1) NULL,
    status varchar(50)  NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
);

-- foreign keys
-- Reference: advertisement_chore_advertisement (table: advertisement_chore)
ALTER TABLE advertisement_chore ADD CONSTRAINT advertisement_chore_advertisement
    FOREIGN KEY (advertisement_id)
    REFERENCES advertisement (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: advertisement_coordinate (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT advertisement_coordinate
    FOREIGN KEY (coordinate_id)
    REFERENCES coordinate (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: advertisement_county (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT advertisement_county
    FOREIGN KEY (county_id)
    REFERENCES county (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: advertisment_city (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT advertisment_city
    FOREIGN KEY (city_id)
    REFERENCES city (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: advertisment_tool (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT advertisment_tool
    FOREIGN KEY (tool_id)
    REFERENCES tool (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: advertisment_type (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT advertisment_type
    FOREIGN KEY (type_id)
    REFERENCES type (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: advertisment_user (table: advertisement)
ALTER TABLE advertisement ADD CONSTRAINT advertisment_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: city_county (table: city)
ALTER TABLE city ADD CONSTRAINT city_county
    FOREIGN KEY (county_id)
    REFERENCES county (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: contact_county (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_county
    FOREIGN KEY (county_id)
    REFERENCES county (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: contact_user (table: contact)
ALTER TABLE contact ADD CONSTRAINT contact_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: feedback_user (table: feedback)
ALTER TABLE feedback ADD CONSTRAINT feedback_user
    FOREIGN KEY (receiver_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: receiver_message_user (table: message)
ALTER TABLE message ADD CONSTRAINT receiver_message_user
    FOREIGN KEY (receiver_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: sender_message_user (table: message)
ALTER TABLE message ADD CONSTRAINT sender_message_user
    FOREIGN KEY (sender_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_chore_chore (table: advertisement_chore)
ALTER TABLE advertisement_chore ADD CONSTRAINT user_chore_chore
    FOREIGN KEY (chore_id)
    REFERENCES chore (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_info_city (table: contact)
ALTER TABLE contact ADD CONSTRAINT user_info_city
    FOREIGN KEY (city_id)
    REFERENCES city (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_info_image (table: contact)
ALTER TABLE contact ADD CONSTRAINT user_info_image
    FOREIGN KEY (image_id)
    REFERENCES image (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

