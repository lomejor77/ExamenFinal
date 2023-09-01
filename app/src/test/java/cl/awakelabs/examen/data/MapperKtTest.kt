package cl.awakelabs.examen.data

import cl.awakelabs.examen.data.local.HeroDetailEntity
import cl.awakelabs.examen.data.remote.Details
import cl.awakelabs.examen.data.remote.Hero
import org.junit.Assert.*

import org.junit.Test

class MapperKtTest {

    @Test
    fun transform() {
        //Given
        val oneHero = Hero(2,"heman","eternia","example.com", "alto", 1986)
        //When
        val result = oneHero.transform()

        //them
        assertEquals(oneHero.id,result.id)
        assertEquals(oneHero.name,result.name)
        assertEquals(oneHero.origin,result.origin)
        assertEquals(oneHero.image,result.image)
        assertEquals(oneHero.power,result.power)
        assertEquals(oneHero.since,result.since)

    }

    @Test
    fun transformToDetail() {
        //Given
        val oneDetail = Details(2,"heman","eternia","example.com", "alto", 1986,"rojo",true)
        //When
        val result = oneDetail.transformToDetail()

        //them
        assertEquals(oneDetail.id,result.id)
        assertEquals(oneDetail.name,result.name)
        assertEquals(oneDetail.origin,result.origin)
        assertEquals(oneDetail.image,result.image)
        assertEquals(oneDetail.power,result.power)
        assertEquals(oneDetail.since,result.since)
        assertEquals(oneDetail.color,result.color)
        assertEquals(oneDetail.translate,result.translate)

    }
}