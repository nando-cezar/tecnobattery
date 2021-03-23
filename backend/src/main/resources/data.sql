
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('ADMIN', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste1', 'teste1@teste.com', '12346789', true, true, true, true);
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('ADMIN', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste2', 'teste2@teste.com', '12346789', true, true, true, true);
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('ADMINTRAINEE', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste3', 'teste3@teste.com', '12346789', true, true, true, true);
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('ADMINTRAINEE', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste4', 'teste4@teste.com', '12346789', false, false, false, false);
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('ADMINTRAINEE', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste5', 'teste5@teste.com', '12346789', false, false, false, false);
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('ADMIN', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste6', 'teste6@teste.com', '12346789', true, true, true, true);
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('EMPLOYEE', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste7', 'teste7@teste.com', '12346789', true, true, true, true);
INSERT INTO tb_user (role, password, username, email, phone_number, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled) VALUES ('EMPLOYEE', '$2a$10$/RnTMUf..xYCoj5ksJQHYOfOSvdNvslP9BZj0h6rtKXGHE2SwyEC6', 'teste8', 'teste8@teste.com', '12346789', true, true, true, true);
 
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace1', 'Complement1', 'Neighborhood1', 'City1', 'State1');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace2', 'Complement2', 'Neighborhood2', 'City2', 'State2');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace3', 'Complement3', 'Neighborhood3', 'City3', 'State3');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace4', 'Complement4', 'Neighborhood4', 'City4', 'State4');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace5', 'Complement5', 'Neighborhood5', 'City5', 'State5');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace6', 'Complement6', 'Neighborhood6', 'City6', 'State6');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace7', 'Complement7', 'Neighborhood7', 'City7', 'State7');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace8', 'Complement8', 'Neighborhood8', 'City8', 'State8');
INSERT INTO tb_address (postal_Code, public_Place, complement, neighborhood, city, state) VALUES ('12345', 'publicPlace9', 'Complement9', 'Neighborhood9', 'City9', 'State9');

INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-52', 'Client1', 'Cliente1', '1234679', 'teste_client1@teste.com', 1);
INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-59', 'Client2', 'Cliente2', '1234679', 'teste_client2@teste.com', 2);
INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-58', 'Client3', 'Cliente3', '1234679', 'teste_client3@teste.com', 3);
INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-57', 'Client4', 'Cliente4', '1234679', 'teste_client4@teste.com', 4);
INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-56', 'Client5', 'Cliente5', '1234679', 'teste_client5@teste.com', 5);
INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-55', 'Client6', 'Cliente6', '1234679', 'teste_client6@teste.com', 6);
INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-54', 'Client7', 'Cliente7', '1234679', 'teste_client6@teste.com', 7);
INSERT INTO tb_client (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-53', 'Client8', 'Cliente8', '1234679', 'teste_client8@teste.com', 8);
 
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-52', 'Provider1', 'Provider1', '1234679', 'teste_provider1@teste.com', 1);
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-59', 'Provider2', 'Provider2', '1234679', 'teste_provider2@teste.com', 2);
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-58', 'Provider3', 'Provider3', '1234679', 'teste_provider3@teste.com', 3);
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-57', 'Provider4', 'Provider4', '1234679', 'teste_provider4@teste.com', 4);
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-56', 'Provider5', 'Provider5', '1234679', 'teste_provider5@teste.com', 5);
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-55', 'Provider6', 'Provider6', '1234679', 'teste_provider6@teste.com', 6);
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-54', 'Provider7', 'Provider7', '1234679', 'teste_provider7@teste.com', 7);
INSERT INTO tb_provider (cnpj, name, fantasy_Name, phone_number, email, address_id) VALUES ('02.905.450/0001-53', 'Provider8', 'Provider8', '1234679', 'teste_provider8@teste.com', 8);

INSERT INTO tb_battery (brand, model, capacity, voltage, diameter, height, weight, image_Url) VALUES ('Battery1', 'ModelBattery1', 100, 1000, 200, 300, 30, 'www.teste.com');
INSERT INTO tb_battery (brand, model, capacity, voltage, diameter, height, weight, image_Url) VALUES ('Battery2', 'ModelBattery2', 100, 2000, 200, 300, 30, 'www.teste.com');
INSERT INTO tb_battery (brand, model, capacity, voltage, diameter, height, weight, image_Url) VALUES ('Battery3', 'ModelBattery3', 100, 3000, 200, 300, 30, 'www.teste.com');
INSERT INTO tb_battery (brand, model, capacity, voltage, diameter, height, weight, image_Url) VALUES ('Battery4', 'ModelBattery4', 100, 1000, 200, 300, 30, 'www.teste.com');
INSERT INTO tb_battery (brand, model, capacity, voltage, diameter, height, weight, image_Url) VALUES ('Battery5', 'ModelBattery5', 100, 5000, 200, 300, 30, 'www.teste.com');
INSERT INTO tb_battery (brand, model, capacity, voltage, diameter, height, weight, image_Url) VALUES ('Battery6', 'ModelBattery6', 100, 3000, 200, 300, 30, 'www.teste.com');
INSERT INTO tb_battery (brand, model, capacity, voltage, diameter, height, weight, image_Url) VALUES ('Battery7', 'ModelBattery7', 100, 4000, 200, 300, 30, 'www.teste.com');

INSERT INTO tb_board (brand, model, power, voltage, width, height, length, weight, image_Url) VALUES ('Board1', 'ModelBoard1', 100, 1000, 200, 300, 100, 30, 'www.teste.com');
INSERT INTO tb_board (brand, model, power, voltage, width, height, length, weight, image_Url) VALUES ('Board2', 'ModelBoard2', 100, 2000, 200, 300, 100, 30, 'www.teste.com');
INSERT INTO tb_board (brand, model, power, voltage, width, height, length, weight, image_Url) VALUES ('Board3', 'ModelBoard3', 100, 3000, 200, 300, 100, 30, 'www.teste.com');
INSERT INTO tb_board (brand, model, power, voltage, width, height, length, weight, image_Url) VALUES ('Board4', 'ModelBoard4', 100, 1000, 200, 300, 100, 30, 'www.teste.com');
INSERT INTO tb_board (brand, model, power, voltage, width, height, length, weight, image_Url) VALUES ('Board5', 'ModelBoard5', 100, 5000, 200, 300, 100, 30, 'www.teste.com');
INSERT INTO tb_board (brand, model, power, voltage, width, height, length, weight, image_Url) VALUES ('Board6', 'ModelBoard6', 100, 3000, 200, 300, 100, 30, 'www.teste.com');
INSERT INTO tb_board (brand, model, power, voltage, width, height, length, weight, image_Url) VALUES ('Board7', 'ModelBoard7', 100, 4000, 200, 300, 100, 30, 'www.teste.com');

INSERT INTO tb_loader (brand, model, power, voltage, width, height, length, image_Url) VALUES ('Board1', 'ModelBoard1', 100, 1000, 200, 300, 100, 'www.teste.com');
INSERT INTO tb_loader (brand, model, power, voltage, width, height, length, image_Url) VALUES ('Board2', 'ModelBoard2', 100, 2000, 200, 300, 100, 'www.teste.com');
INSERT INTO tb_loader (brand, model, power, voltage, width, height, length, image_Url) VALUES ('Board3', 'ModelBoard3', 100, 3000, 200, 300, 100, 'www.teste.com');
INSERT INTO tb_loader (brand, model, power, voltage, width, height, length, image_Url) VALUES ('Board4', 'ModelBoard4', 100, 1000, 200, 300, 100, 'www.teste.com');
INSERT INTO tb_loader (brand, model, power, voltage, width, height, length, image_Url) VALUES ('Board5', 'ModelBoard5', 100, 5000, 200, 300, 100, 'www.teste.com');
INSERT INTO tb_loader (brand, model, power, voltage, width, height, length, image_Url) VALUES ('Board6', 'ModelBoard6', 100, 3000, 200, 300, 100, 'www.teste.com');
INSERT INTO tb_loader (brand, model, power, voltage, width, height, length, image_Url) VALUES ('Board7', 'ModelBoard7', 100, 4000, 200, 300, 100, 'www.teste.com');

INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Pizza Bacon',        49, 49, 1000, 1000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg' );
INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Pizza Moda da Casa', 59, 59, 2000, 2000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg');
INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Pizza Portuguesa',   45, 45, 3000, 3000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_portuguesa.jpg');
INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Risoto de Carne',    52, 52, 1000, 1000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_carne.jpg');
INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Risoto Funghi',      59, 59, 5000, 5000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg');
INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Macarrão Espaguete', 35, 35, 3000, 3000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg');
INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Macarrão Fusili',    38, 38, 4000, 4000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_fusili.jpg');
INSERT INTO tb_product (name, power, capacity, voltage, price, description, image_Url) VALUES ('Macarrão Penne',     37, 37, 4000, 4000, 'fsdf', 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_penne.jpg');

INSERT INTO tb_order (client_id, description, price, status, opening, deadline) VALUES (1, 'Produto BAT 2S2P', 100,  'PENDENTE', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_order (client_id, description, price, status, opening, deadline) VALUES (3, 'Produto BAT 4S3P', 100,  'PENDENTE', TIMESTAMP WITH TIME ZONE '2021-01-01T15:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-01T15:00:00Z');
INSERT INTO tb_order (client_id, description, price, status, opening, deadline) VALUES (4, 'Produto BAT 1S2P', 100,  'ENTREGUE', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z');
INSERT INTO tb_order (client_id, description, price, status, opening, deadline) VALUES (2, 'Produto BAT 3S1P', 100,  'ENTREGUE', TIMESTAMP WITH TIME ZONE '2021-01-01T12:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-01T12:00:00Z');
INSERT INTO tb_order (client_id, description, price, status, opening, deadline) VALUES (2, 'Produto BAT 5S6P', 100,  'PENDENTE', TIMESTAMP WITH TIME ZONE '2021-01-01T08:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-01T08:00:00Z');
INSERT INTO tb_order (client_id, description, price, status, opening, deadline) VALUES (5, 'Produto BAT 4S4P', 100,  'PENDENTE', TIMESTAMP WITH TIME ZONE '2021-01-01T14:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-01T14:00:00Z');
INSERT INTO tb_order (client_id, description, price, status, opening, deadline) VALUES (6, 'Produto BAT 1S2P', 100,  'PENDENTE', TIMESTAMP WITH TIME ZONE '2021-01-01T09:00:00Z', TIMESTAMP WITH TIME ZONE '2021-01-01T09:00:00Z');

INSERT INTO tb_comment(order_id, user_id, title, description, moment) VALUES (1,  1, 'Title1',   'Commentario 1', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_comment(order_id, user_id, title, description, moment) VALUES (2,  1, 'Title2',   'Commentario 2', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_comment(order_id, user_id, title, description, moment) VALUES (2,  2, 'Title3',   'Commentario 3', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_comment(order_id, user_id, title, description, moment) VALUES (4,  2, 'Title4',   'Commentario 4', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_comment(order_id, user_id, title, description, moment) VALUES (5,  3, 'Title5',   'Commentario 5', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');
INSERT INTO tb_comment(order_id, user_id, title, description, moment) VALUES (6,  3, 'Title6',   'Commentario 6', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z');

INSERT INTO tb_management_battery(provider_id, battery_id, moment, amount) VALUES (1,  1, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_battery(provider_id, battery_id, moment, amount) VALUES (1,  2, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_battery(provider_id, battery_id, moment, amount) VALUES (2,  3, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_battery(provider_id, battery_id, moment, amount) VALUES (3,  4, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_battery(provider_id, battery_id, moment, amount) VALUES (3,  5, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_battery(provider_id, battery_id, moment, amount) VALUES (4,  6, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_battery(provider_id, battery_id, moment, amount) VALUES (5,  7, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);

INSERT INTO tb_management_board(provider_id, board_id, moment, amount) VALUES (1,  1, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_board(provider_id, board_id, moment, amount) VALUES (1,  2, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_board(provider_id, board_id, moment, amount) VALUES (2,  3, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_board(provider_id, board_id, moment, amount) VALUES (3,  4, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_board(provider_id, board_id, moment, amount) VALUES (3,  5, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_board(provider_id, board_id, moment, amount) VALUES (4,  6, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_board(provider_id, board_id, moment, amount) VALUES (5,  7, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);

INSERT INTO tb_management_loader(provider_id, loader_id, moment, amount) VALUES (1,  1, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_loader(provider_id, loader_id, moment, amount) VALUES (1,  2, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_loader(provider_id, loader_id, moment, amount) VALUES (2,  3, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_loader(provider_id, loader_id, moment, amount) VALUES (3,  4, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_loader(provider_id, loader_id, moment, amount) VALUES (3,  5, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_loader(provider_id, loader_id, moment, amount) VALUES (4,  6, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);
INSERT INTO tb_management_loader(provider_id, loader_id, moment, amount) VALUES (5,  7, TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 20);

INSERT INTO tb_order_user (order_id, user_id) VALUES (1 , 1);
INSERT INTO tb_order_user (order_id, user_id) VALUES (1 , 4);
INSERT INTO tb_order_user (order_id, user_id) VALUES (2 , 2);
INSERT INTO tb_order_user (order_id, user_id) VALUES (2 , 5);
INSERT INTO tb_order_user (order_id, user_id) VALUES (2 , 8);
INSERT INTO tb_order_user (order_id, user_id) VALUES (3 , 3);
INSERT INTO tb_order_user (order_id, user_id) VALUES (3 , 4);
INSERT INTO tb_order_user (order_id, user_id) VALUES (4 , 2);
INSERT INTO tb_order_user (order_id, user_id) VALUES (4 , 6);
INSERT INTO tb_order_user (order_id, user_id) VALUES (5 , 4);
INSERT INTO tb_order_user (order_id, user_id) VALUES (5 , 6);
INSERT INTO tb_order_user (order_id, user_id) VALUES (6 , 5);
INSERT INTO tb_order_user (order_id, user_id) VALUES (6 , 1);
INSERT INTO tb_order_user (order_id, user_id) VALUES (7 , 7);
INSERT INTO tb_order_user (order_id, user_id) VALUES (7 , 5);

INSERT INTO tb_order_product (order_id, product_id) VALUES (1 , 1);
INSERT INTO tb_order_product (order_id, product_id) VALUES (4 , 1);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 2);
INSERT INTO tb_order_product (order_id, product_id) VALUES (5 , 2); 
INSERT INTO tb_order_product (order_id, product_id) VALUES (7 , 2);
INSERT INTO tb_order_product (order_id, product_id) VALUES (3 , 3);
INSERT INTO tb_order_product (order_id, product_id) VALUES (4 , 3);
INSERT INTO tb_order_product (order_id, product_id) VALUES (2 , 4);
