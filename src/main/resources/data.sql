insert into cities (name, is_on_seaside) values
('Paris', false),
('Monaco', true),
('Amsterdam', false),
('Barcelona', true);

insert into attractions (name, city_id, is_available_for_children) values
('Eiffel Tower', 1,  true),
('Moulin Rouge', 1,  false),
('Monaco Casino', 2, false),
('Red lights street', 3, false),
('van Gogh museum', 3, true),
('Barcelona night clubs', 4, false),
('La Rambla', 4, true);