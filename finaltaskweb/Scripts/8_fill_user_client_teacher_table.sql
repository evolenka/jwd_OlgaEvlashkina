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

INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"andreev",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"meshkov",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"POTAPAVA",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);

INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"penkina",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"kuvshinka",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"koblova",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"Umishukova",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"efimenko",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"fedorovE",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"popova",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"shut1000",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"kobec",
	"YFGjdu7d56ggy/wePXzb+py==",
	'CLIENT'
);
INSERT INTO `user` (
	`login`,
	`password`,
	`role`
) VALUES (
	"sobstkristi",
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
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "11",
	"Андреев",
	"Илья",
	"Александрович",
	"andreev@mail.ru",
	"+375(44)758-98-78"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "12",
	"Мешков",
	"Дмитрий",
	"Иванович",
	"meshkov@gmail.com",
	"+375(29)687-79-12"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "13",
	"Потапова",
	"Маргарита",
	"Марковна",
	"POTAPAVA@mail.ru",
	"+375(29)189-84-80"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "14",
	"Пенкина",
	"Анна",
	"Николаевна",
	"penkina@mail.ru",
	"+375(44)758-98-81"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "15",
	"Кувшинова",
	"Екатерина",
	"Михайловна",
	"kuvshinka@mail.ru",
	"+375(25)658-98-82"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "16",
	"Коблова",
	"Любовь",
	"Дмитриевна",
	"koblova@mail.ru",
	"+375(44)858-02-83"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "17",
	"Мишукова",
	"Ульяна",
	"Алексеевна",
	"Umishukova@gmail.com",
	"+375(44)245-89-36"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "18",
	"Ефименко",
	"Маргарита",
	"Сергеевна",
	"fimenko@mail.ru",
	"+375(44)714-98-85"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "19",
	"Федоров",
	"Евгений",
	"Денисович",
	"fedorovE@mail.ru",
	"+375(29)198-78-58"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "20",
	"Попова",
	"Александра",
	"Сергеевна",
	"popova@gmail.com",
	"+375(25)713-38-87"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "21",
	"Шутов",
	"Сергей",
	"Федорович",
	"shut1000@mail.ru",
	"+375(29)700-915-88"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "22",
	"Кобец",
	"Станислав",
	"Александрович",
	"kobec@mail.ru",
	"+375(44)7145-98-48"
	);
INSERT INTO `client` (
    `id`,
    `surname`,
	`name`,
	`patronymic`,
	`email`,
	`phone`
) VALUES (
    "23",
	"Собственникова",
	"Кристина",
	"Станиславовна",
	"sobstkristi@mail.ru",
	"+375(44)145-78-25"
	);