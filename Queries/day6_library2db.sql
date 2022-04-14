-- USE LOWERCASE FOR TABLE NAME
-- THIS PARTICULAR DATABASE CONFIGURED TO ONLY USE LOWERCASE FOR TABLE NAME

SELECT COUNT(*) FROM books;

select COUNT(*) from users;

-- Display the book name and book category name
-- books , book_categories tables are related by book_category_id

-- this is not an alias version
SELECT books.name, book_categories.name
FROM books
         INNER JOIN book_categories ON books.book_category_id = book_categories.id;

-- this is an alias version
SELECT b.name, bc.name
FROM books b
         Inner join book_categories bc on b.book_category_id = bc.id;