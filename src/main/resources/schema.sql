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

