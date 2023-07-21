-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dinamita
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dinamita
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dinamita` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `dinamita` ;

-- -----------------------------------------------------
-- Table `dinamita`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dinamita`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `role_id` INT UNSIGNED NULL DEFAULT NULL,
  `name` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `avatar` VARCHAR(255) NULL DEFAULT 'users/default.png',
  `email_verified_at` TIMESTAMP NULL DEFAULT NULL,
  `password` VARCHAR(255) NOT NULL,
  `remember_token` VARCHAR(100) NULL DEFAULT NULL,
  `settings` TEXT NULL DEFAULT NULL,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `users_email_unique` (`email` ASC) VISIBLE,
  INDEX `users_role_id_foreign` (`role_id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `dinamita`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dinamita`.`orders` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_number` VARCHAR(255) NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `status` ENUM('pending', 'processing', 'completed', 'decline') NOT NULL DEFAULT 'pending',
  `grand_total` DOUBLE(8,2) NOT NULL,
  `item_count` INT NOT NULL,
  `is_paid` TINYINT(1) NOT NULL DEFAULT '0',
  `payment_method` ENUM('cash_on_delivery', 'paypal', 'stripe', 'card') NOT NULL DEFAULT 'cash_on_delivery',
  `shipping_fullname` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `orders_user_id_foreign` (`user_id` ASC) VISIBLE,
  CONSTRAINT `orders_user_id_foreign`
    FOREIGN KEY (`user_id`)
    REFERENCES `dinamita`.`users` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `dinamita`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dinamita`.`products` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `price` DOUBLE(8,2) NOT NULL,
  `cover_img` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 51
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `dinamita`.`order_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dinamita`.`order_items` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `order_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `price` DOUBLE(8,2) NOT NULL,
  `quantity` INT NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT NULL,
  `updated_at` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_items_product_id_foreign` (`product_id` ASC) VISIBLE,
  INDEX `order_items_order_id_foreign` (`order_id` ASC) VISIBLE,
  CONSTRAINT `order_items_order_id_foreign`
    FOREIGN KEY (`order_id`)
    REFERENCES `dinamita`.`orders` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `order_items_product_id_foreign`
    FOREIGN KEY (`product_id`)
    REFERENCES `dinamita`.`products` (`id`)
    ON DELETE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
