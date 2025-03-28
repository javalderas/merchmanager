-- Usuario admin (admin@banda.com / admin123)
INSERT INTO users (email, password) VALUES
('admin@banda.com', '$2a$10$7zzY79r9BvFvfsW3ZkN3EeyZLMWip0HZ0O9qS.WZ1plFGz9YYj56W');

-- Confirma que el init se ejecutó
SELECT '✅ INIT OK' AS resultado;
