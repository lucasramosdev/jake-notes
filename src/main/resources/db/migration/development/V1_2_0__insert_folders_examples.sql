INSERT INTO folders (id, name, parent_id, created_at, updated_at) VALUES
(1, 'trabalho', NULL, '2026-03-01 00:00:00', NULL),
(2, 'estudos', NULL, '2026-03-01 00:00:00', NULL),
(3, 'criacao', NULL, '2026-03-01 00:00:00', NULL),
(4, 'projetos', NULL, '2026-03-01 00:00:00', NULL),
(5, 'referencias', NULL, '2026-03-01 00:00:00', NULL),
(6, 'pessoal', NULL, '2026-03-01 00:00:00', NULL),
(7, 'videos', NULL, '2026-03-01 00:00:00', NULL),
(8, 'leitura', NULL, '2026-03-01 00:00:00', NULL),
(9, 'eventos', NULL, '2026-03-01 00:00:00', NULL),
(10, 'ideias', NULL, '2026-03-01 00:00:00', NULL);

SELECT setval('folders_id_seq', (SELECT MAX(id) FROM folders));