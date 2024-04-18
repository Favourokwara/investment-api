INSERT INTO investors (investor_id, national_id, first_name, last_name, email, dob)
VALUES (1, '8902124567890', 'Thandiwe', 'Mthembu', 'thandi@example.com', '1989-02-21'),
       (2, '7801021234567', 'Nomfundo', 'Ngubane', 'nfundo@example.com', '1978-01-10'),
       (3, '9211142345678', 'Siyabonga', 'Ndlovu', 'siyalv@example.com', '1992-11-14'),
       (4, '8806303456789', 'Bongani', 'Nkosi', 'bonganiN@example.com', '1988-06-30');

INSERT INTO products (product_id, name, balance, product_type)
VALUES (1, 'Retirement Fund', 10000.5, 0),
       (2, 'Savings Account', 2005.1, 1),
       (3, 'Investment Plan', 5029.1, 1);


INSERT INTO investor_products (investor_id, product_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (3, 3),
       (4, 2);