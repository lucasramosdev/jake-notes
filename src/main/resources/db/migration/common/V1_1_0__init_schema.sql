BEGIN;

CREATE TABLE folders (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_id INTEGER,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    CONSTRAINT fk_folders
        FOREIGN KEY (parent_id)
        REFERENCES folders(id)
        ON DELETE CASCADE
);

CREATE TABLE notes (
    id SERIAL PRIMARY KEY,
    folder_id INTEGER,
    title TEXT NOT NULL,
    summary TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    CONSTRAINT fk_folders_notes
        FOREIGN KEY (folder_id)
        REFERENCES folders(id)
        ON DELETE CASCADE
);

CREATE TABLE notes_tags (
    note_id INTEGER NOT NULL,
    tag_value VARCHAR(25) NOT NULL,
    PRIMARY KEY (note_id, tag_value),
    CONSTRAINT fk_notes_notes_tags
        FOREIGN KEY (note_id)
        REFERENCES notes(id)
        ON DELETE CASCADE
);

CREATE TABLE topics (
    id SERIAL PRIMARY KEY,
    keyword VARCHAR(255) NOT NULL,
    details TEXT NOT NULL,
    note_id INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    CONSTRAINT fk_notes_topics
        FOREIGN KEY (note_id)
           REFERENCES notes(id)
           ON DELETE CASCADE
);

COMMIT;