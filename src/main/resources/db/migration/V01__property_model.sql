CREATE TABLE properties (
    id serial PRIMARY KEY,
    owner VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    number_of_rooms INTEGER,
    number_of_bathrooms INTEGER,
    type VARCHAR(100),
    publication_date TIMESTAMP DEFAULT now(),
    updated_date TIMESTAMP ,
    status VARCHAR(50),
    price DOUBLE PRECISION,
    property_type VARCHAR(50)
);