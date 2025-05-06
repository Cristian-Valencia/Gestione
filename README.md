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

INSERT INTO post (postId, title, content, createdAt) VALUES
('POST001', 'Introduzione al nuovo framework', 'Oggi abbiamo lanciato un nuovo framework rivoluzionario che semplificherà lo sviluppo delle nostre applicazioni. Leggi di più per scoprire come iniziare!', '2025-05-06'),
('POST002', 'Guida passo-passo all\'installazione', 'Questa guida dettagliata ti accompagnerà attraverso il processo di installazione del nostro nuovo software. Segui attentamente ogni passaggio.', '2025-05-05'),
('POST003', 'Le migliori pratiche per la sicurezza del codice', 'In questo articolo esploreremo alcune delle migliori pratiche per garantire la sicurezza del tuo codice e proteggere i tuoi utenti.', '2025-05-04'),
('POST004', 'Novità dell\'ultima release', 'Scopri tutte le nuove funzionalità e i miglioramenti inclusi nell\'ultima versione del nostro prodotto. Non perderti le entusiasmanti novità!', '2025-05-03'),
('POST005', 'Consigli per ottimizzare le performance del tuo sito web', 'Se il tuo sito web è lento, non preoccuparti! Ecco alcuni consigli pratici per migliorare le sue performance e offrire una migliore esperienza agli utenti.', '2025-05-02'),
('POST006', 'Intervista esclusiva con il CEO', 'Abbiamo avuto l\'opportunità di intervistare il nostro CEO per discutere della visione aziendale e dei piani per il futuro. Leggi l\'intervista completa qui.', '2025-05-01'),
('POST007', 'Come utilizzare al meglio la nostra API', 'Questa guida ti mostrerà come sfruttare al meglio la nostra potente API per integrare i nostri servizi nelle tue applicazioni.', '2025-04-30'),
('POST008', 'Evento online: non perderti la live session!', 'Ti invitiamo al nostro prossimo evento online dove presenteremo le ultime novità e risponderemo alle tue domande in diretta.', '2025-04-29'),
('POST009', 'Storie di successo dei nostri utenti', 'Leggi le testimonianze di alcuni dei nostri utenti che hanno ottenuto risultati straordinari utilizzando i nostri prodotti e servizi.', '2025-04-28'),
('POST010', 'Prossimi aggiornamenti e roadmap', 'Ecco un\'anteprima dei prossimi aggiornamenti in arrivo e della nostra roadmap di sviluppo per i prossimi mesi.', '2025-04-27');

-- inserimento di 10 record nella tabella category

INSERT INTO category (categoryId, nameCategory) VALUES
('CAT001', 'Elettronica'),
('CAT002', 'Libri'),
('CAT003', 'Abbigliamento'),
('CAT004', 'Casa e Giardino'),
('CAT005', 'Sport e Tempo Libero'),
('CAT006', 'Bellezza e Cura Personale'),
('CAT007', 'Giocattoli e Bambini'),
('CAT008', 'Alimentari'),
('CAT009', 'Automotive'),
('CAT010', 'Musica e Film');

-- inserimento nella tabella di appoggio per creare una relazione many to many 

INSERT INTO post_category (postid, categoryid) VALUES
(1, 1),  -- Post "Introduzione al nuovo framework" in "Elettronica"
(1, 5),  -- Post "Introduzione al nuovo framework" in "Sport e Tempo Libero" 
(2, 1),  -- Post "Guida passo-passo all'installazione" in "Elettronica"
(2, 9),  -- Post "Guida passo-passo all'installazione" in "Automotive" 
(3, 3),  -- Post "Le migliori pratiche per la sicurezza del codice" in "Abbigliamento" 
(3, 1),  -- Post "Le migliori pratiche per la sicurezza del codice" in "Elettronica" 
(4, 1),  -- Post "Novità dell'ultima release" in "Elettronica"
(4, 3),  -- Post "Novità dell'ultima release" in "Abbigliamento" 
(5, 1),  -- Post "Consigli per ottimizzare le performance del tuo sito web" in "Elettronica" 
(5, 9),  -- Post "Consigli per ottimizzare le performance del tuo sito web" in "Automotive" 
(6, 1),  -- Post "Intervista esclusiva con il CEO" in "Elettronica" 
(6, 9),  -- Post "Intervista esclusiva con il CEO" in "Automotive" 
(7, 1),  -- Post "Come utilizzare al meglio la nostra API" in "Elettronica"
(8, 1),  -- Post "Evento online: non perderti la live session!" in "Elettronica"
(8, 3),  -- Post "Evento online: non perderti la live session!" in "Abbigliamento" 
(9, 3),  -- Post "Storie di successo dei nostri utenti" in "Abbigliamento"
(9, 9),  -- Post "Storie di successo dei nostri utenti" in "Automotive"
(10, 1), -- Post "Prossimi aggiornamenti e roadmap" in "Elettronica"
(10, 3), -- Post "Prossimi aggiornamenti e roadmap" in "Abbigliamento"
(10, 9); -- Post "Prossimi aggiornamenti e roadmap" in "Automotive"

-- query di lettura per scegliere tutti i post
-- SELECT * FROM post;

-- query di lettura per scegliere un post attraverso il suo id
-- SELECT * FROM post WHERE id = 1;

-- query di update di un post
-- UPDATE post SET title = "Introduzione al nuovo framework" WHERE id = 1;

-- query di delete di un post
-- DELETE FROM post WHERE id = 1;

-- query di insert di un post
-- INSERT INTO post (postId, title, content, createdAt) VALUES ("AAA", "BBB", "CCC", '2025-05-06');


-- query di lettura per scegliere tutti i category
-- SELECT * FROM category;

-- query di lettura per scegliere un post attraverso il suo id
-- SELECT * FROM category WHERE id = 1;

-- query di update di un post
-- UPDATE category SET nameCategory = "Introduzione al nuovo framework" WHERE id = 1;

-- query di delete di un post
-- DELETE FROM category WHERE id = 1;

-- query di insert di un post
-- INSERT INTO category (categoryId, nameCategory) VALUES ("AAA", "BBB");
 
-- relazione many to many facciamo la query di lettura per prendere un post e dire a quale categoria è associata

-- SELECT
--     p.id AS post_id,
--     p.title AS post_title,
--     c.id AS category_id,
--     c.nameCategory AS category_name
-- FROM
--     post p
-- JOIN
--     post_category pc ON p.id = pc.postId
-- JOIN
--     category c ON pc.categoryId = c.id
-- WHERE
--     p.id = 2;

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

