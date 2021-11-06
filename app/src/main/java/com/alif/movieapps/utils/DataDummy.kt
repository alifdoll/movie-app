package com.alif.movieapps.utils

import com.alif.movieapps.data.entity.DataEntity
import com.alif.movieapps.data.source.remote.response.EntityItems

object DataDummy {

    fun getDummyMovie(): List<DataEntity> {
        val entities = ArrayList<DataEntity>()

        entities.add(
            DataEntity(1,
            "Raya and the Last Dragon",
            "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                "https://image.tmdb.org/t/p/original/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
            "Movie",
            false
        )
        )
        entities.add(
            DataEntity(2,
            "Tom & Jerry",
            "Tom the cat and Jerry the mouse gets kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
            "https://image.tmdb.org/t/p/original/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
            "Movie",
            false
        )
        )
        entities.add(
            DataEntity(3,
            "Below Zero",
            "When a prisoner transfer van is attacked, the cop in charge must fight those inside and outside while dealing with a silent foe: the icy temperatures.",
            "https://image.tmdb.org/t/p/original/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg",
            "Movie",
            false
        )
        )
        entities.add(
            DataEntity(4,
            "Sentinelle",
            "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
            "https://image.tmdb.org/t/p/original/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg",
            "Movie",
            false
        )
        )
        entities.add(
            DataEntity(5,
            "Zack Snyder's Justice League",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            "https://image.tmdb.org/t/p/original/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            "Movie",
            false
        )
        )
        entities.add(
            DataEntity(6,
                "Monster Hunter",
                "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                "https://image.tmdb.org/t/p/original/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                "Movie",
                false
        )
        )
        entities.add(
            DataEntity(7,
                "Wonder Woman 1984",
                "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy.",
                "https://image.tmdb.org/t/p/original/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "Movie",
                false
        )
        )
        entities.add(
            DataEntity(8,
                "Space Sweepers",
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "https://image.tmdb.org/t/p/original/qiUesQForGW872kIC0Crqx3vAr0.jpg",
                "Movie",
                false
        )
        )
        entities.add(
            DataEntity(9,
                "Coming 2 America",
                "Prince Akeem Joffer is set to become King of Zamunda when he discovers he has a son he never knew about in America – a street savvy Queens native named Lavelle. Honoring his royal father's dying wish to groom this son as the crown prince, Akeem and Semmi set off to America once again.",
                "https://image.tmdb.org/t/p/original/nWBPLkqNApY5pgrJFMiI9joSI30.jpg",
                "Movie",
                false
        )
        )
        entities.add(
            DataEntity(10,
                "Outside the Wire",
                "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                "https://image.tmdb.org/t/p/original/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg",
                "Movie",
                false
        )
        )

        return entities
    }

    fun getDummyShow(): List<DataEntity> {
        val entities = ArrayList<DataEntity>()

        entities.add(
            DataEntity(1,
                "The Falcon and the Winter Soldier",
            "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "https://image.tmdb.org/t/p/original/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(2,
            "The Good Doctor",
            "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://image.tmdb.org/t/p/original/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(3,
            "The Flash",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(4,
            "Invincible",
            "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "https://image.tmdb.org/t/p/original/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(5,
                "Love, Death & Robots",
                "Terrifying creatures, wicked surprises and dark comedy converge in this NSFW anthology of animated stories presented by Tim Miller and David Fincher.",
                "https://image.tmdb.org/t/p/original/asDqvkE66EegtKJJXIRhBJPxscr.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(6,
            "Jupiter's Legacy",
            "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "https://image.tmdb.org/t/p/original/9yxep7oJdkj3Pla9TD9gKflRApY.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(7,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "https://image.tmdb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(8,
            "Grey's Anatomy",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(9,
            "Luis Miguel: The Series",
            "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "https://image.tmdb.org/t/p/original/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg",
                "Show",
                false
        )
        )
        entities.add(
            DataEntity(10,
                "Lucifer",
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://image.tmdb.org/t/p/original/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg",
                "Show",
                false
        )
        )

        return entities
    }

    fun getRemoteMovieResponses(): ArrayList<EntityItems> {
        val entities = ArrayList<EntityItems>()

        entities.add(
            EntityItems(1,
                        "Raya and the Last Dragon",
                        "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                        "https://image.tmdb.org/t/p/original/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                )
        )
        entities.add(
            EntityItems(2,
                        "Tom & Jerry",
                        "Tom the cat and Jerry the mouse gets kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                        "https://image.tmdb.org/t/p/original/6KErczPBROQty7QoIsaa6wJYXZi.jpg"
                )
        )
        entities.add(
            EntityItems(3,
                        "Below Zero",
                        "When a prisoner transfer van is attacked, the cop in charge must fight those inside and outside while dealing with a silent foe: the icy temperatures.",
                        "https://image.tmdb.org/t/p/original/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg"
                )
        )
        entities.add(
            EntityItems(4,
                        "Sentinelle",
                        "Transferred home after a traumatizing combat mission, a highly trained French soldier uses her lethal skills to hunt down the man who hurt her sister.",
                        "https://image.tmdb.org/t/p/original/fFRq98cW9lTo6di2o4lK1qUAWaN.jpg"
                )
        )
        entities.add(
            EntityItems(5,
                        "Zack Snyder's Justice League",
                        "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                        "https://image.tmdb.org/t/p/original/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"
                )
        )
        entities.add(
            EntityItems(6,
                        "Monster Hunter",
                        "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                        "https://image.tmdb.org/t/p/original/1UCOF11QCw8kcqvce8LKOO6pimh.jpg"
                )
        )
        entities.add(
            EntityItems(7,
                        "Wonder Woman 1984",
                        "A botched store robbery places Wonder Woman in a global battle against a powerful and mysterious ancient force that puts her powers in jeopardy.",
                        "https://image.tmdb.org/t/p/original/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg"
                )
        )
        entities.add(
            EntityItems(8,
                        "Space Sweepers",
                        "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                        "https://image.tmdb.org/t/p/original/qiUesQForGW872kIC0Crqx3vAr0.jpg"
                )
        )
        entities.add(
            EntityItems(9,
                        "Coming 2 America",
                        "Prince Akeem Joffer is set to become King of Zamunda when he discovers he has a son he never knew about in America – a street savvy Queens native named Lavelle. Honoring his royal father's dying wish to groom this son as the crown prince, Akeem and Semmi set off to America once again.",
                        "https://image.tmdb.org/t/p/original/nWBPLkqNApY5pgrJFMiI9joSI30.jpg"
                )
        )
        entities.add(
            EntityItems(10,
                        "Outside the Wire",
                        "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                        "https://image.tmdb.org/t/p/original/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg"
                )
        )

        return entities
    }

    fun getRemoteShowResponse(): ArrayList<EntityItems> {
        val entities = ArrayList<EntityItems>()

        entities.add(
            EntityItems(1,
                "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "https://image.tmdb.org/t/p/original/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )
        entities.add(
            EntityItems(2,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://image.tmdb.org/t/p/original/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )
        entities.add(
            EntityItems(3,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "https://image.tmdb.org/t/p/original/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )
        entities.add(
            EntityItems(4,
                "Invincible",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage.",
                "https://image.tmdb.org/t/p/original/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg"
            )
        )
        entities.add(
            EntityItems(5,
                "Love, Death & Robots",
                "Terrifying creatures, wicked surprises and dark comedy converge in this NSFW anthology of animated stories presented by Tim Miller and David Fincher.",
                "https://image.tmdb.org/t/p/original/asDqvkE66EegtKJJXIRhBJPxscr.jpg",
            )
        )
        entities.add(
            EntityItems(6,
                "Jupiter's Legacy",
                "When the world's first generation of superheroes received their powers in the 1930s become the revered elder guard in the present, their superpowered children struggle to live up to the legendary feats of their parents.",
                "https://image.tmdb.org/t/p/original/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
            )
        )
        entities.add(
            EntityItems(7,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "https://image.tmdb.org/t/p/original/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg"
            )
        )
        entities.add(
            EntityItems(8,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "https://image.tmdb.org/t/p/original/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )
        entities.add(
            EntityItems(9,
                "Luis Miguel: The Series",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "https://image.tmdb.org/t/p/original/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg"
            )
        )
        entities.add(
            EntityItems(10,
                "Lucifer",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
                "https://image.tmdb.org/t/p/original/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg"
            )
        )

        return entities
    }


}