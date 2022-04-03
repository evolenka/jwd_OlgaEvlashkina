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
	"Танцевальный опыт 6 лет. Опыт преподавания 3 года. Участница международных и республиканских соревнований. Многократная чемпионка в составе команды на Белорусских Чемпионатах и Конкурсах."
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
	"В танцах уже 18 лет. Опыт преподавания 6 лет. Постановщик и участник конкурсных программ, ТВ-Шоу, музыкальных клипов, рекламных видеороликов и подтанцовок"
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
	"Окончила БГУКИ с отличием, эстрадное отделение. Опыт преподавания более 10 лет. 
Призер множества международных и республиканских соревнований."
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
    "5",
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
    "6",
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
    "7",
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
    "8",
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
    "9",
	"Степнов",
	"Кирилл",
	"Александрович",
	"stepnovka@mail.ru",
	"+375(29)259-47-15"
	);
INSERT INTO `group` (
    `id`,
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "1",
	"group1",
	"2",
	"beg"
	);
INSERT INTO `group` (
    `id`,
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "2",
	"group2",
	"2",
	"pro"
	);
INSERT INTO `group` (
    `id`,
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "3",
	"group3",
	"3",
	"beg"
	);
INSERT INTO `group` (
    `id`,
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "4",
	"group4",
	"3",
	"pro"
	);
INSERT INTO `group` (
    `id`,
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "5",
	"group5",
	"4",
	"beg"
	);
INSERT INTO `group` (
    `id`,
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "6",
	"group6",
	"4",
	"pro"
	);
INSERT INTO `group` (
    `id`,
    `title`,
	`teacher_id`,
	`level`
) VALUES (
    "7",
	"group7",
	"5",
	"beg"
	);