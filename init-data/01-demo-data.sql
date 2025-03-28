-- Productos de merchandising
INSERT INTO product (name, category, price, cost, stock)
VALUES
  ('Camiseta Negra', 'T-SHIRT', 20.0, 8.0, 30),
  ('CD Tour 2023', 'CD', 10.0, 3.0, 50),
  ('Pegatina', 'STICKER', 2.0, 0.2, 100);

-- Usuario de prueba (password = admin123, con BCrypt)
INSERT INTO users (email, password)
VALUES (
  'admin@banda.com',
  '$2a$10$7zzY79r9BvFvfsW3ZkN3EeyZLMWip0HZ0O9qS.WZ1plFGz9YYj56W'
);
 