-- Create jokes table
CREATE TABLE IF NOT EXISTS jokes (
    id BIGSERIAL PRIMARY KEY,
    setup TEXT NOT NULL,
    punchline TEXT NOT NULL
);

-- Insert sample jokes
INSERT INTO jokes (setup, punchline) VALUES
('Why did the scarecrow get a promotion?', 'Because he was outstanding in his field.'),
('I told my wife she was drawing her eyebrows too high.', 'She looked surprised.'),
('Why don''t skeletons fight each other?', 'They don''t have the guts.');
