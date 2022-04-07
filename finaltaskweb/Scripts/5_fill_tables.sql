USE `dancestudio_db`;

INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"tpavlova",
	"VLD1B6ane2DpKxt9PkIC9g==",
	'TEACHER'
);

INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"divanov",
	"rZDdprnLVXNuvafESK0DUA==",
	'TEACHER'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"olesnaya",
	"ufuE2rE3X5GOegBcxcsedA==",
	'TEACHER'
);

INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"atalai",
	"qas64XWX8NI4PXz6h+b/vw==",
	'TEACHER'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"MARKOVA",
	"Uas78XWK8NI4PXz6h+b/vw==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"nataliana",
	"U0Tcja4XuTrc4I9sWAIr6w==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"vikkra",
	"pfg78g4XWX8NI4PXz6h+c/vw==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"anastaissakis",
	"qas64XWX8NI4PXz6h+b+yu==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"kirstepnov",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `teacher` (
    `id`,
    `surname`,
	`name`,
	`dancestyle`,
	`portfolio`
) VALUES (
    "2",
	"Павлова",
	"Татьяна",
	"contemporary",
	"Танцевальный опыт - 6 лет. Опыт преподавания - 3 года. Участница международных и республиканских соревнований. Многократная чемпионка в составе команды на Белорусских Чемпионатах и Конкурсах."
	);
INSERT INTO `teacher` (
    `id`,
    `surname`,
	`name`,
	`dancestyle`,
	`portfolio`
	) VALUES (
    "3",
	"Иванов",
	"Дмитрий",
	"hip-hop",
	"В танцах уже 18 лет. Опыт преподавания - 6 лет. Постановщик и участник конкурсных программ, ТВ-Шоу, музыкальных клипов, рекламных видеороликов и подтанцовок"
	);
	INSERT INTO `teacher` (
    `id`,
    `surname`,
	`name`,
	`dancestyle`,
	`portfolio`
) VALUES (
    "4",
	"Лесная",
	"Ольга",
	"jazz-funk",
	"Окончила БГУКИ с отличием, эстрадное отделение. Опыт преподавания более 10 лет. Призер множества международных и республиканских соревнований."
	);
	INSERT INTO `teacher` (
    `id`,
    `surname`,
	`name`,
	`dancestyle`,
	`portfolio`
) VALUES (
    "5",
	"Талай",
	"Александра",
	"vogue",
	"Танцевальный опыт - более 15 лет! Стажировка в театре в Берлине. Участие в международных конкурсах и мастер-классах"
	);

INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "6",
	"Маркова",
	"Мария",
	"Алексеевна",
	"markovamarialex@gmail.com",
	"+375(29)768-45-36"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "7",
	"Андреева",
	"Наталья",
	"Николаевна",
	"nnandreeva85@mail.ru",
	"+375(44)741-58-96"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "8",
	"Кратова",
	"Виктория",
	"Петровна",
	"kratkovavikki@gmail.com",
	"+375(44)789-41-78"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "9",
	"Киселева",
	"Анастасия",
	"Алексеевна",
	"akiseleva89@mail.ru",
	"+375(29)698-25-63"
	);

INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "10",
	"Степнов",
	"Кирилл",
	"Александрович",
	"stepnovka@mail.ru",
	"+375(29)259-47-15"
	);
INSERT INTO `group` (
    `title`,
	`teacher_id`,
	`level`
) VALUES (
  	"group1",
	"2",
	"beg"
	);
INSERT INTO `group` (
    `title`,
	`teacher_id`,
	`level`
) VALUES (
   	"group2",
	"2",
	"pro"
	);
INSERT INTO `group` (
    `title`,
	`teacher_id`,
	`level`
) VALUES (
   	"group3",
	"3",
	"beg"
	);
INSERT INTO `group` (
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "group4",
	"3",
	"pro"
	);
INSERT INTO `group` (
    `title`,
	`teacher_id`,
	`level`
) VALUES (
   	"group5",
	"4",
	"beg"
	);
INSERT INTO `group` (
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "group6",
	"4",
	"pro"
	);
INSERT INTO `group` (
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "group7",
	"5",
	"beg"
	);
INSERT INTO `type_of_membership` (
    `title`,
	`max_class_quantity`,
	`price`
) VALUES (
   	"GUEST",
	"1",
	"15"
	);
INSERT INTO `type_of_membership` (
    `title`,
	`max_class_quantity`,
	`price`
) VALUES (
   	"LIGHT",
	"4",
	"48"
	);
INSERT INTO `type_of_membership` (
    `title`,
	`max_class_quantity`,
	`price`
) VALUES (
   	"BASIC",
	"8",
	"80"
	);
INSERT INTO `type_of_membership` (
    `id`,
    `title`,
	`max_class_quantity`,
	`price`
) VALUES (
    "4",
   	"STRONG",
	"16",
	"150"
	);
INSERT INTO `type_of_membership` (
    `id`,
    `title`,
	`price`
) VALUES (
     "5",
   	"UNLIM",
	"190"
	);
INSERT INTO `membership` (
    `client_id`,
	`type_of_membership_id`,
	`start_date`,
	`end_date`,
	`balance_quantity`	
) VALUES (
   	"5",
	"1",
	"2022-03-12",
	"2022-03-13",
	"0"
	);
INSERT INTO `membership` (
    `client_id`,
	`type_of_membership_id`,
	`start_date`,
	`end_date`,
	`balance_quantity`	
) VALUES (
   	"6",
	"2",
	"2022-04-01",
	"2022-05-01",
	"4"
	);
INSERT INTO `membership` (
    `client_id`,
	`type_of_membership_id`,
	`start_date`,
	`end_date`,
	`balance_quantity`
) VALUES (
    "6",
	"1",
	"2022-03-28",
	"2022-03-29",
	"1"	
	);
INSERT INTO `membership` (
    `client_id`,
	`type_of_membership_id`,
	`start_date`,
	`end_date`,
	`balance_quantity`
) VALUES (
    "7",
	"1",
	"2022-04-02",
	"2022-04-03",
	"1"	
	);
INSERT INTO `membership` (
    `client_id`,
	`type_of_membership_id`,
	`start_date`,
	`end_date`,
	`balance_quantity`
) VALUES (
    "7",
	"3",
	"2022-04-07",
	"2022-05-07",
	"8"	
	);
INSERT INTO `membership` (
    `client_id`,
	`type_of_membership_id`,
	`start_date`,
	`end_date`
	) VALUES (
    "8",
	"5",
	"2022-04-10",
	"2022-05-10"
);
INSERT INTO `membership` (
    `client_id`,
	`type_of_membership_id`,
	`start_date`,
	`end_date`,
	`balance_quantity`
	) VALUES (
    "9",
	"4",
	"2022-04-10",
	"2022-05-10",
	"16"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "MONDAY",
	"18:00",
	"60",
	"1"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "MONDAY",
	"19:00",
	"60",
	"2"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "MONDAY",
	"20:00",
	"60",
	"5"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "TUESDAY",
	"18:00",
	"60",
	"3"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "TUESDAY",
	"19:00",
	"60",
	"4"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "TUESDAY",
	"20:00",
	"60",
	"6"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "WEDNESDAY",
	"18:00",
	"60",
	"1"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "WEDNESDAY",
	"19:00",
	"60",
	"2"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "WEDNESDAY",
	"20:00",
	"60",
	"5"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "THURSDAY",
	"18:00",
	"60",
	"3"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "THURSDAY",
	"19:00",
	"60",
	"4"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "THURSDAY",
	"20:00",
	"60",
	"6"
);
INSERT INTO `schedule` (
    `weekday`,
	`time`,
	`duration`,
	`group_id`
	) VALUES (
    "FRIDAY",
	"18:00",
	"90",
	"7"
);
