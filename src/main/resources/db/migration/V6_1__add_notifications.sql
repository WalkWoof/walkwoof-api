-- Início do Passeio
INSERT INTO notifications (type, message, created_at, user_id)
VALUES
('Início do Passeio', 'Seu passeio com [Nome do Cachorro] está começando agora! Acompanhe a rota em tempo real.', NOW(), 1),
('Início do Passeio', 'O Walker está a caminho para buscar [Nome do Cachorro]! Prepare-se para o passeio!', NOW(), 1);

-- Atualizações do Passeio
INSERT INTO notifications (type, message, created_at, user_id)
VALUES
('Atualização do Passeio', 'O [Walker] e [Nome do Cachorro] já estão a caminho! Veja onde eles estão agora.', NOW(), 1),
('Atualização do Passeio', 'Rota do passeio atualizada! [Nome do Cachorro] está se divertindo!', NOW(), 1);

-- Finalização do Passeio
INSERT INTO notifications (type, message, created_at, user_id)
VALUES
('Finalização do Passeio', 'Passeio com [Nome do Cachorro] concluído! Veja a rota percorrida e os detalhes.', NOW(), 1),
('Finalização do Passeio', 'O [Walker] entregou [Nome do Cachorro] em casa! Como foi o passeio?', NOW(), 1);

-- Lembretes e Agendamentos
INSERT INTO notifications (type, message, created_at, user_id)
VALUES
('Lembrete de Passeio', 'Tem um passeio agendado com [Nome do Cachorro] para amanhã às [hora]. Pronto para o passeio?', NOW(), 1),
('Lembrete de Agendamento', 'Não se esqueça de agendar o passeio da semana! [Nome do Cachorro] está esperando!', NOW(), 1);

-- Notificações de Serviço
INSERT INTO notifications (type, message, created_at, user_id)
VALUES
('Serviço Disponível', 'Seu Walker preferido está disponível para novos passeios! Agende agora.', NOW(), 1),
('Promoção', 'Aproveite! Desconto exclusivo para o próximo passeio de [Nome do Cachorro].', NOW(), 1);

-- Atividades de Saúde e Bem-estar
INSERT INTO notifications (type, message, created_at, user_id)
VALUES
('Atividade de Saúde', 'Bom para a saúde! [Nome do Cachorro] completou mais de [número] km este mês.', NOW(), 1),
('Atividade Física', 'Hora de mais um passeio para manter [Nome do Cachorro] ativo e feliz!', NOW(), 1);

