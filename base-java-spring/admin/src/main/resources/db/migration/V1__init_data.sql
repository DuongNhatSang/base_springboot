CREATE TABLE IF NOT EXISTS `users` (
    `id` VARCHAR(36) PRIMARY KEY,
    `name` varchar(150) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `user_name` varchar(300) NOT NULL,
    `password` varchar(150) DEFAULT NULL,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `deleted_at` timestamp DEFAULT NULL
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS `role` (
    `id` VARCHAR(36) PRIMARY KEY,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `name` varchar(255) NOT NULL,
    `deleted_at` timestamp DEFAULT NULL
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--
-- Dumping data for table `role`
--
LOCK TABLES `role` WRITE;

/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO
    `role`
VALUES
    (
        '00000000-0000-0000-0000-000000000000',
        '2023-09-05 18:29:40',
        '2023-09-05 18:29:40',
        'ROLE_ADMIN',
        NULL
    ),
    (
        '00000000-0000-0000-0000-000000000001',
        '2023-09-05 18:29:40',
        '2023-09-05 18:29:40',
        'ROLE_USER',
        NULL
    ),
    (
        '00000000-0000-0000-0000-000000000002',
        '2023-09-25 18:29:40',
        '2023-09-25 18:29:40',
        'ROLE_STAFF',
        NULL
    );

/*!40000 ALTER TABLE `role` ENABLE KEYS */;

UNLOCK TABLES;

CREATE TABLE IF NOT EXISTS `user_role` (
    `id` VARCHAR(36) PRIMARY KEY,
    `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `role_id` VARCHAR(36) DEFAULT NULL,
    `user_id` VARCHAR(36) NOT NULL,
    `deleted_at` timestamp DEFAULT NULL,
    KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
    KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
    CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
    CONSTRAINT `user_role_users_FK` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;