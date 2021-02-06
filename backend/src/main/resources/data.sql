INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste1@teste.com', 0, 'a123456', 'teste1');
INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste2@teste.com', 1, 'b123456', 'teste2');
INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste3@teste.com', 0, 'c123456', 'teste3');
INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste4@teste.com', 1, 'd123456', 'teste4');
INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste5@teste.com', 0, 'e123456', 'teste5');
INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste6@teste.com', 1, 'f123456', 'teste6');
INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste7@teste.com', 0, 'g123456', 'teste7');
INSERT INTO tb_user (email, level, password, username) VALUES ( 'teste8@teste.com', 1, 'h123456', 'teste8');

INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-52', 'testee1@teste.com', 'Client1', 'Cliente1', '1234679');
INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-59', 'testee2@teste.com', 'Client2', 'Cliente2', '1234679');
INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-58', 'testee3@teste.com', 'Client3', 'Cliente3', '1234679');
INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-57', 'testee4@teste.com', 'Client4', 'Cliente4', '1234679');
INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-56', 'testee5@teste.com', 'Client5', 'Cliente5', '1234679');
INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-55', 'testee6@teste.com', 'Client6', 'Cliente6', '1234679');
INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-54','testee6@teste.com',  'Client7', 'Cliente7', '1234679');
INSERT INTO tb_client (cnpj, email, fantasy_Name, name, phone) VALUES ('02.905.450/0001-53', 'testee8@teste.com', 'Client8', 'Cliente8', '1234679');

INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Pizza Bacon', 49.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_bacon.jpg', 'Pizza de bacon com mussarela, orégano, molho especial e tempero da casa.');
INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Pizza Moda da Casa', 59.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_moda.jpg', 'Pizza à moda da casa, com molho especial e todos ingredientes básicos, e queijo à sua escolha.');
INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Pizza Portuguesa', 45.0, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/pizza_portuguesa.jpg', 'Pizza Portuguesa com molho especial, mussarela, presunto, ovos e especiarias.');
INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Risoto de Carne', 52.0, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_carne.jpg', 'Risoto de carne com especiarias e um delicioso molho de acompanhamento.');
INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Risoto Funghi', 59.95, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/risoto_funghi.jpg', 'Risoto Funghi feito com ingredientes finos e o toque especial do chef.');
INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Macarrão Espaguete', 35.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_espaguete.jpg', 'Macarrão fresco espaguete com molho especial e tempero da casa.');
INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Macarrão Fusili', 38.0, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_fusili.jpg', 'Macarrão fusili com toque do chef e especiarias.');
INSERT INTO tb_product (name, price, image_Url, description) VALUES ('Macarrão Penne', 37.9, 'https://raw.githubusercontent.com/devsuperior/sds2/master/assets/macarrao_penne.jpg', 'Macarrão penne fresco ao dente com tempero especial.');

INSERT INTO tb_request (client, description, moment, total, user) VALUES (1, 'Produto BAT 2S2P', TIMESTAMP WITH TIME ZONE '2021-01-01T10:00:00Z', 100, 1);
INSERT INTO tb_request (client, description, moment, total, user) VALUES (3, 'Produto BAT 4S3P', TIMESTAMP WITH TIME ZONE '2021-01-01T15:00:00Z', 100, 2);
INSERT INTO tb_request (client, description, moment, total, user) VALUES (4, 'Produto BAT 1S2P', TIMESTAMP WITH TIME ZONE '2021-01-01T16:00:00Z', 100, 3);
INSERT INTO tb_request (client, description, moment, total, user) VALUES (2, 'Produto BAT 3S1P', TIMESTAMP WITH TIME ZONE '2021-01-01T12:00:00Z', 100, 1);
INSERT INTO tb_request (client, description, moment, total, user) VALUES (2, 'Produto BAT 5S6P', TIMESTAMP WITH TIME ZONE '2021-01-01T08:00:00Z', 100, 5);
INSERT INTO tb_request (client, description, moment, total, user) VALUES (5, 'Produto BAT 4S54P', TIMESTAMP WITH TIME ZONE '2021-01-01T14:00:00Z',100, 3);
INSERT INTO tb_request (client, description, moment, total, user) VALUES (6, 'Produto BAT 1S2P',  TIMESTAMP WITH TIME ZONE '2021-01-01T09:00:00Z',100, 4);

INSERT INTO tb_client_request (client_id, request_id) VALUES (1 , 1);
INSERT INTO tb_client_request (client_id, request_id) VALUES (1 , 4);
INSERT INTO tb_client_request (client_id, request_id) VALUES (2 , 2);
INSERT INTO tb_client_request (client_id, request_id) VALUES (2 , 5);
INSERT INTO tb_client_request (client_id, request_id) VALUES (2 , 7);
INSERT INTO tb_client_request (client_id, request_id) VALUES (3 , 3);
INSERT INTO tb_client_request (client_id, request_id) VALUES (3 , 4);
INSERT INTO tb_client_request (client_id, request_id) VALUES (4 , 2);

INSERT INTO tb_user_request (user_id, request_id) VALUES (1 , 1);
INSERT INTO tb_user_request (user_id, request_id) VALUES (1 , 4);
INSERT INTO tb_user_request (user_id, request_id) VALUES (2 , 2);
INSERT INTO tb_user_request (user_id, request_id) VALUES (2 , 5);
INSERT INTO tb_user_request (user_id, request_id) VALUES (2 , 7);
INSERT INTO tb_user_request (user_id, request_id) VALUES (3 , 3);
INSERT INTO tb_user_request (user_id, request_id) VALUES (3 , 4);
INSERT INTO tb_user_request (user_id, request_id) VALUES (4 , 2);


INSERT INTO tb_request_product (request_id, product_id) VALUES (1 , 1);
INSERT INTO tb_request_product (request_id, product_id) VALUES (1 , 4);
INSERT INTO tb_request_product (request_id, product_id) VALUES (2 , 2);
INSERT INTO tb_request_product (request_id, product_id) VALUES (2 , 5);
INSERT INTO tb_request_product (request_id, product_id) VALUES (2 , 8);
INSERT INTO tb_request_product (request_id, product_id) VALUES (3 , 3);
INSERT INTO tb_request_product (request_id, product_id) VALUES (3 , 4);
INSERT INTO tb_request_product (request_id, product_id) VALUES (4 , 2);
INSERT INTO tb_request_product (request_id, product_id) VALUES (4 , 6);
INSERT INTO tb_request_product (request_id, product_id) VALUES (5 , 4);
INSERT INTO tb_request_product (request_id, product_id) VALUES (5 , 6);
INSERT INTO tb_request_product (request_id, product_id) VALUES (6 , 5);
INSERT INTO tb_request_product (request_id, product_id) VALUES (6 , 1);
INSERT INTO tb_request_product (request_id, product_id) VALUES (7 , 7);
INSERT INTO tb_request_product (request_id, product_id) VALUES (7 , 5);