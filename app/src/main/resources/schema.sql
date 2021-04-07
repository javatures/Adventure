create table enemies (
    enemytype text primary key,
    health int,
    attack int,
    defense int,
    dodge int
);

create table weapons (
    weaponname text primary key,
    attack int
);

create table armors (
    armorname text primary key,
    defense int,
    dodge int
);

insert into enemies (enemytype, health, attack, defense, dodge) values ('goblin', 5, 1, 0, 10);
insert into enemies (enemytype, health, attack, defense, dodge) values ('rogue', 10, 2, 0, 25);
insert into enemies (enemytype, health, attack, defense, dodge) values ('wizard', 10, 4, 0, 10);
insert into enemies (enemytype, health, attack, defense, dodge) values ('troll', 20, 3, 1, 0);
insert into enemies (enemytype, health, attack, defense, dodge) values ('demon', 30, 4, 2, 5);
insert into weapons (weaponname, attack) values ('none', 0);
insert into weapons (weaponname, attack) values ('dagger', 1);
insert into weapons (weaponname, attack) values ('sword', 2);
insert into weapons (weaponname, attack) values ('excalibur', 3);
insert into armors (armorname, defense, dodge) values ('none', 0, 0);
insert into armors (armorname, defense, dodge) values ('leather', 1, 0);
insert into armors (armorname, defense, dodge) values ('iron', 2, 0);
insert into armors (armorname, defense, dodge) values ('light', 0, 10);