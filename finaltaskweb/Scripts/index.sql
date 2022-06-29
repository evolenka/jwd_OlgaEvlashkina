DELETE FROM `membership` WHERE id = 11;
SELECT membership.id, membership.start_date, membership.end_date, membership.balance_quantity, membership.type_of_membership_id FROM `membership` WHERE membership.client_id = 6 AND membership.balance_quantity > 0 AND membership.end_date <= current_date()

UPDATE `type_of_membership` SET title = 'LIGHT', max_class_quantity = 4, price = 48 WHERE id = 5;

SELECT membership.client_id, membership.start_date, membership.end_date, membership.balance_quantity, membership.type_of_membership_id FROM `membership` WHERE membership.id = 3
UPDATE `group` SET title = 'group7', teacher_id = 5, level = 'BEG' WHERE id = 7
UPDATE `group` SET title = ?, teacher_id = ?, level = ? WHERE id = ?

SERT INTO `type_of_membership` (
    `title`,
	`max_class_quantity`,
	`price`
) VALUES (
   	"LIGHT",
	"4",
	"48"
	);