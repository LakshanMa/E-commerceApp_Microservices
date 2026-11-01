-- Categories
insert into category (id, description, name)
values (nextval('category_seq'), 'Computer keyboards and keypads', 'Keyboards');
insert into category (id, description, name)
values (nextval('category_seq'), 'Computer monitors and displays', 'Monitors');
insert into category (id, description, name)
values (nextval('category_seq'), 'Display screens and projectors', 'Screens');
insert into category (id, description, name)
values (nextval('category_seq'), 'Computer mice and pointing devices', 'Mice');
insert into category (id, description, name)
values (nextval('category_seq'), 'Computer accessories and peripherals', 'Accessories');

-- Keyboards
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 10, 'Mechanical keyboard with RGB lighting', 'Mechanical Keyboard 1', 99.99,
        (select id from category where name = 'Keyboards'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 15, 'Wireless compact keyboard', 'Wireless Compact Keyboard 1', 79.99,
        (select id from category where name = 'Keyboards'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 20, 'Backlit keyboard with customizable keys', 'Backlit Keyboard 1', 129.99,
        (select id from category where name = 'Keyboards'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 25, 'Gaming keyboard with programmable macros', 'Gaming Keyboard 1', 149.99,
        (select id from category where name = 'Keyboards'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 18, 'Ergonomic split keyboard', 'Ergonomic Keyboard 1', 119.99,
        (select id from category where name = 'Keyboards'));

-- Monitors
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 30, '27-inch IPS monitor with 4K resolution', '4K Monitor 1', 399.99,
        (select id from category where name = 'Monitors'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 25, 'Ultra-wide gaming monitor with 144Hz refresh rate', 'Gaming Monitor 1', 499.99,
        (select id from category where name = 'Monitors'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 22, '24-inch LED monitor for office use', 'Office Monitor 1', 179.99,
        (select id from category where name = 'Monitors'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 28, '32-inch curved monitor with HDR support', 'Curved Monitor 1', 349.99,
        (select id from category where name = 'Monitors'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 12, 'Portable USB-C monitor for laptops', 'Portable Monitor 1', 199.99,
        (select id from category where name = 'Monitors'));

-- Screens
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 15, 'Curved OLED gaming screen with 240Hz refresh rate', 'Curved OLED Gaming Screen 1', 799.99,
        (select id from category where name = 'Screens'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 18, 'Full HD projector with 3000 lumens', 'HD Projector 1', 449.99,
        (select id from category where name = 'Screens'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 10, '100-inch motorized projection screen', 'Projection Screen 1', 299.99,
        (select id from category where name = 'Screens'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 8, '55-inch interactive touch display', 'Interactive Display 1', 1299.99,
        (select id from category where name = 'Screens'));

-- Mice
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 40, 'Wireless ergonomic mouse', 'Ergonomic Mouse 1', 49.99,
        (select id from category where name = 'Mice'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 35, 'Gaming mouse with adjustable DPI', 'Gaming Mouse 1', 69.99,
        (select id from category where name = 'Mice'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 50, 'Compact Bluetooth travel mouse', 'Travel Mouse 1', 29.99,
        (select id from category where name = 'Mice'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 20, 'Vertical mouse for wrist comfort', 'Vertical Mouse 1', 59.99,
        (select id from category where name = 'Mice'));

-- Accessories
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 60, 'Extended desk mouse pad', 'Desk Mouse Pad 1', 19.99,
        (select id from category where name = 'Accessories'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 45, '7-port USB 3.0 hub', 'USB Hub 1', 34.99,
        (select id from category where name = 'Accessories'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 30, 'Adjustable aluminum laptop stand', 'Laptop Stand 1', 39.99,
        (select id from category where name = 'Accessories'));
insert into product (id, available_quantity, description, name, price, category_id)
values (nextval('product_seq'), 25, '1080p HD webcam with built-in microphone', 'HD Webcam 1', 59.99,
        (select id from category where name = 'Accessories'));
