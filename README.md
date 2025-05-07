** creazione di un servizio REST per un BLOG **

** creazione delle tabelle in SQL **

DROP DATABASE IF EXISTS progetto_categoria_post; 
CREATE DATABASE progetto_categoria_post; 
USE progetto_categoria_post;

-- creazione della tabella post con gli attributi indicati dalla consegna

CREATE TABLE post (

id INT PRIMARY KEY AUTO_INCREMENT,
postId VARCHAR(10) NOT NULL UNIQUE,
title VARCHAR(250) NOT NULL,
content VARCHAR(500) NOT NULL,
author VARCHAR(250) NOT NULL,
createdAt DATE NOT NULL
);

-- creazione della tabella category con gli attributi indicati dalla consegna

CREATE TABLE category (

id INT PRIMARY KEY AUTO_INCREMENT,
categoryId VARCHAR(10) NOT NULL UNIQUE,
nameCategory VARCHAR(250) NOT NULL
);

-- creazione della tabella di appoggio per indicare

CREATE TABLE post_category (

postId INT,
categoryId INT,
PRIMARY KEY (postId, categoryId),
FOREIGN KEY (postId) REFERENCES post(id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (categoryId) REFERENCES category(id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- inserimento di 10 record nella tabella di post

INSERT INTO post (postId, title, content, author, createdAt)
VALUES
('POST001', 'Introduzione al Backend con Node.js', 'Un articolo introduttivo sui concetti fondamentali del backend utilizzando Node.js e Express.', 'Mario Rossi', '2025-05-01'),
('POST002', 'Le Migliori Pratiche per il Frontend React', 'Scopri come scrivere codice React pulito, manutenibile e performante seguendo le migliori pratiche.', 'Laura Bianchi', '2025-05-02'),
('POST003', 'Guida Avanzata all\'Utilizzo di Docker', 'Esplora le funzionalità avanzate di Docker per la containerizzazione e l\'orchestrazione delle tue applicazioni.', 'Giovanni Verdi', '2025-05-03'),
('POST004', 'Ottimizzazione delle Query SQL per Performance Elevate', 'Tecniche e strategie per scrivere query SQL efficienti e migliorare le prestazioni del tuo database.', 'Sofia Neri', '2025-05-03'),
('POST005', 'Introduzione al Machine Learning con Python', 'Un approccio pratico ai concetti base del machine learning utilizzando la libreria scikit-learn.', 'Riccardo Gialli', '2025-05-04'),
('POST006', 'Creare API RESTful con Spring Boot', 'Una guida passo passo per costruire API RESTful robuste e scalabili utilizzando il framework Spring Boot.', 'Elena Blu', '2025-05-05'),
('POST007', 'Sicurezza Web: Prevenire gli Attacchi più Comuni', 'Comprendi le vulnerabilità web più comuni e impara come proteggere le tue applicazioni.', 'Marco Arancio', '2025-05-05'),
('POST008', 'Test Unitari Efficaci con Jest e Enzyme', 'Scrivi test unitari affidabili per le tue componenti React utilizzando Jest ed Enzyme.', 'Francesca Viola', '2025-05-06'),
('POST009', 'GraphQL vs REST: Quale Scegliere per il Tuo Progetto?', 'Un confronto dettagliato tra le architetture GraphQL e REST per aiutarti a prendere la decisione giusta.', 'Simone Marrone', '2025-05-06'),
('POST010', 'Deploy Continuo con Jenkins e Kubernetes', 'Automatizza il processo di deploy delle tue applicazioni utilizzando Jenkins e Kubernetes.', 'Alessia Rosa', '2025-05-07'),
('POST011', 'Novità e Funzionalità di PHP 8', 'Esplora le nuove caratteristiche e i miglioramenti introdotti nella versione 8 del linguaggio PHP.', 'Paolo Argento', '2025-05-07');


-- inserimento di 10 record nella tabella category

INSERT INTO category (categoryId, nameCategory)
VALUES
('CAT001', 'Backend'),
('CAT002', 'Frontend'),
('CAT003', 'DevOps'),
('CAT004', 'Database'),
('CAT005', 'Machine Learning'),
('CAT006', 'Java'),
('CAT007', 'Sicurezza Informatica'),
('CAT008', 'Testing'),
('CAT009', 'Architetture Software'),
('CAT010', 'Automazione'),
('CAT011', 'PHP');

-- inserimento nella tabella di appoggio per creare una relazione many to many

INSERT INTO post_category (postId, categoryId) VALUES
(1, 1),   -- Introduzione al Backend (Backend)
(1, 3),   -- Introduzione al Backend (DevOps)
(2, 2),   -- Le Migliori Pratiche per il Frontend (Frontend)
(2, 8),   -- Le Migliori Pratiche per il Frontend (Testing)
(3, 3),   -- Guida Avanzata a Docker (DevOps)
(4, 4),   -- Ottimizzazione Query SQL (Database)
(5, 5),   -- Introduzione al Machine Learning (Machine Learning)
(5, 4),   -- Introduzione al Machine Learning (Database - per gestione dati)
(6, 6),   -- Creare API RESTful con Spring Boot (Java)
(6, 1),   -- Creare API RESTful con Spring Boot (Backend)
(7, 7),   -- Sicurezza Web (Sicurezza Informatica)
(8, 2),   -- Test Unitari con Jest e Enzyme (Frontend)
(8, 8),   -- Test Unitari con Jest e Enzyme (Testing)
(9, 9),   -- GraphQL vs REST (Architetture Software)
(9, 1),   -- GraphQL vs REST (Backend)
(9, 2),   -- GraphQL vs REST (Frontend)
(10, 3),  -- Deploy Continuo con Jenkins e Kubernetes (DevOps)
(10, 10), -- Deploy Continuo con Jenkins e Kubernetes (Automazione)
(11, 1),  -- Novità e Funzionalità di PHP 8 (Backend)
(11, 11), -- Novità e Funzionalità di PHP 8 (PHP)
(3, 10),  -- Guida Avanzata a Docker (Automazione)
(7, 3),   -- Sicurezza Web (DevOps - per il deployment sicuro)
(4, 1),   -- Ottimizzazione Query SQL (Backend - per le performance)
(5, 9);   -- Introduzione al Machine Learning (Architetture Software - per l'integrazione)



-- query di lettura per scegliere tutti i post -- SELECT * FROM post;

-- query di lettura per scegliere un post attraverso il suo id -- SELECT * FROM post WHERE id = 1;

-- query di update di un post -- UPDATE post SET title = "Introduzione al nuovo framework" WHERE id = 1;

-- query di delete di un post -- DELETE FROM post WHERE id = 1;

-- query di insert di un post -- INSERT INTO post (postId, title, content, createdAt) VALUES ("AAA", "BBB", "CCC", '2025-05-06');

-- query di lettura per scegliere tutti i category -- SELECT * FROM category;

-- query di lettura per scegliere un post attraverso il suo id -- SELECT * FROM category WHERE id = 1;

-- query di update di un post -- UPDATE category SET nameCategory = "Introduzione al nuovo framework" WHERE id = 1;

-- query di delete di un post -- DELETE FROM category WHERE id = 1;

-- query di insert di un post -- INSERT INTO category (categoryId, nameCategory) VALUES ("AAA", "BBB");

-- relazione many to many facciamo la query di lettura per prendere un post e dire a quale categoria è associata

-- SELECT
--     c.nameCategory AS category_name
-- FROM
--     post p
-- JOIN
--     post_category pc ON p.id = pc.postId
-- JOIN
--     category c ON pc.categoryId = c.id
-- WHERE
--     p.id = 1 AND c.id = 1;

-- relazione many to many facciamo la query di lettura per prendere una categoria e trovare i post che hanno quella categoria

-- SELECT 
-- 	c.id AS category_id,
--     c.nameCategory AS category_name,
--     p.id AS post_id,
--     P.title AS post_title
-- FROM
-- 	category c
-- JOIN 
-- 	post_category pc ON c.id = pc.categoryId
-- JOIN 
-- 	post p ON pc.postId = p.id
-- WHERE 
-- 	c.id = 3;
--     
-- SELECT * FROM post_category;

