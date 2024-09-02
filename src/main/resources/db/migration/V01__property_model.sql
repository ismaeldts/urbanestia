CREATE TABLE COUNTRIES (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(10) NOT NULL
);

CREATE TABLE CITIES (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL
 );

CREATE TABLE ADDRESS (
    id SERIAL PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    city_id SERIAL REFERENCES CITIES(id),
    postal_code VARCHAR(20) NOT NULL
);

CREATE TABLE PROPERTIES (
    id SERIAL PRIMARY KEY,
    owner VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    country_id bigint REFERENCES COUNTRIES(id),
    guest_capacity INTEGER,
    number_of_rooms INTEGER NOT NULL,
    number_of_bathrooms INTEGER NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    profile_img VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    publication_date TIMESTAMP NOT NULL,
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    address SERIAL REFERENCES ADDRESS(id)
);

CREATE TABLE PROPERTY_IMAGES (
    property_id SERIAL REFERENCES PROPERTIES(id),
    image_url VARCHAR(255) NOT NULL,
    status varchar(255) not null,
    uploaded_date TIMESTAMP,
    uploaded_by varchar(255) not null,
    PRIMARY KEY (property_id, image_url)
);