DROP TABLE page;
DROP TABLE book;
DROP TABLE user;

CREATE TABLE user (
  id                  INT(11)      NOT NULL AUTO_INCREMENT,
  name                VARCHAR(255) NOT NULL,
  mobile_phone_number VARCHAR(255) NOT NULL,
  password            VARCHAR(255) NOT NULL,

  avatar              VARCHAR(255)          DEFAULT '',
  portrait            VARCHAR(255)          DEFAULT '',
  motto               VARCHAR(255)          DEFAULT '',
  email               VARCHAR(255)          DEFAULT '',
  location            VARCHAR(255)          DEFAULT '',
  occupation          VARCHAR(255)          DEFAULT '',
  introduction        VARCHAR(1023)         DEFAULT '',

  sex                 BOOLEAN               DEFAULT TRUE,

  age                 INT(3)                DEFAULT 0,
  book_number         INT(3)                DEFAULT 0,
  followed_number     INT(11)               DEFAULT 0,
  follower_number     INT(11)               DEFAULT 0,
  collected_number    INT(11)               DEFAULT 0,

  birthday            TIMESTAMP             DEFAULT NOW(),
  create_date         TIMESTAMP             DEFAULT NOW(),
  update_date         TIMESTAMP             DEFAULT NOW(),
  UNIQUE (mobile_phone_number),
  PRIMARY KEY (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

CREATE TABLE book (
  id               INT(11)       NOT NULL AUTO_INCREMENT,
  author_id        INT(11)       NOT NULL,
  name             VARCHAR(255)  NOT NULL,
  cover            VARCHAR(255)  NOT NULL,
  category         VARCHAR(255)  NOT NULL,
  style            VARCHAR(255)  NOT NULL,
  introduction     VARCHAR(1023) NOT NULL,

  page_number      INT(3)                 DEFAULT 0,
  collector_number INT(11)                DEFAULT 0,

  create_date      TIMESTAMP              DEFAULT NOW(),
  update_date      TIMESTAMP              DEFAULT NOW(),

  PRIMARY KEY (id),
  FOREIGN KEY (author_id) REFERENCES user (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;

CREATE TABLE page (
  id          INT(11)      NOT NULL AUTO_INCREMENT,
  book_id     INT(11)      NOT NULL,
  image       VARCHAR(255) NOT NULL,
  number      INT(3)                DEFAULT 0,
  create_date TIMESTAMP             DEFAULT NOW(),
  update_date TIMESTAMP             DEFAULT NOW(),
  UNIQUE (number),
  PRIMARY KEY (id),
  FOREIGN KEY (book_id) REFERENCES book (id)
)
  ENGINE = INNODB
  DEFAULT CHARSET = UTF8;