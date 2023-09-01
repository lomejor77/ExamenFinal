package cl.awakelabs.examen.data

import cl.awakelabs.examen.data.local.HeroDetailEntity
import cl.awakelabs.examen.data.local.HeroEntity
import cl.awakelabs.examen.data.remote.Details
import cl.awakelabs.examen.data.remote.Hero

fun Hero.transform(): HeroEntity =
    HeroEntity(
        this.id,
        this.name,
        this.origin,
        this.image,
        this.power,
        this.since
    )

fun Details.transformToDetail(): HeroDetailEntity =
    HeroDetailEntity(
        this.id,
        this.name,
        this.origin,
        this.image,
        this.power,
        this.since,
        this.color,
        this.translate
    )
