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
insert into weapons (weaponname, attack) values ('none', 0);
insert into armors (armorname, defense, dodge) values ('none', 0, 0);