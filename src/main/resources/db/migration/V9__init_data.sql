insert into RESTAURANT (name)
values
('BezSushiNieRuszi' ),
('GaruCzar'),
('KonZKopytkami'),
('PomidorowaZNiedzielnegoRosolu');

insert into order_food_user (email, restaurant_id, role_id, user_name, password, active)
values
('ali@gmail.com',1,1,'Salman Rushi','$2a$12$7q0gWmIXyhPWst2D7LkK4ul7H6Ud4uVam4vgmVk3QM7ZszTM1ur4S', true),
('garuczar@gmail.com',2,1, 'Garry Witcher','$2a$12$ldX8q5hLj36eQx.N5Og6p.nnupLgcB.7pfDZApFtyS0/Rqx9Mfbt2', true ),
('kopyta@gmail.com',3,2,'Sergiusz Kopyto', '$2a$12$iNFzrELoRmYzu9YvDchqS.u7VthSdrG3znrXqH9ZF6ilspbSyWY8W', true),
( 'pomidory@gmail.com',4,2, 'Roman Chwast', '$2a$12$JuJjLoVVABSLcmEHu8BUpevvGKSK2mXJwzQZmfkgf0lNMPG08/jO6', true);

--insert into meal (name, description, category, meal_photo, price, restaurant_id)
--values
--('Humus','1', 'ze świeżej soczewicy', 'PRZYSTAWKI', '');
