CREATE TABLE CS (
                    id UUID PRIMARY KEY,
                    name VARCHAR(255)
);

-- Create sequence for id
CREATE SEQUENCE CS_id_seq START 1;

-- Create the users table
CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       user_name VARCHAR(255)
);

-- Create sequence for id
CREATE SEQUENCE users_id_seq START 1;

-- Create the room table
CREATE TABLE room (
                      id UUID PRIMARY KEY,
                      staff UUID REFERENCES CS(id),
                      consumer UUID REFERENCES users(id),
                      closed BOOLEAN
);

-- Create sequence for id
CREATE SEQUENCE room_id_seq START 1;

-- Create the message table
CREATE TABLE message (
                         id UUID PRIMARY KEY,
                         sender_id UUID,
                         receiver_id UUID,
                         room UUID REFERENCES room(id),
                         sent_time TIMESTAMPTZ,
                         content TEXT
);

-- Create sequence for id
CREATE SEQUENCE message_id_seq START 1;
