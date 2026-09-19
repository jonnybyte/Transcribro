package dev.soupslurpr.transcribro.recognitionservice.whisper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WhisperLanguageTest {

    @Test
    fun `fromLanguageTag returns AUTO for null`() {
        assertEquals(WhisperLanguage.AUTO, WhisperLanguage.fromLanguageTag(null))
    }

    @Test
    fun `fromLanguageTag returns AUTO for empty string`() {
        assertEquals(WhisperLanguage.AUTO, WhisperLanguage.fromLanguageTag(""))
    }

    @Test
    fun `fromLanguageTag returns AUTO for blank string`() {
        assertEquals(WhisperLanguage.AUTO, WhisperLanguage.fromLanguageTag(" "))
    }

    @Test
    fun `fromLanguageTag returns AUTO for AUTO`() {
        assertEquals(WhisperLanguage.AUTO, WhisperLanguage.fromLanguageTag("auto"))
    }

    @Test
    fun `fromLanguageTag maps de-DE to de`() {
        assertEquals("de", WhisperLanguage.fromLanguageTag("de-DE"))
    }

    @Test
    fun `fromLanguageTag maps en-US to en`() {
        assertEquals("en", WhisperLanguage.fromLanguageTag("en-US"))
    }

    @Test
    fun `fromLanguageTag maps fr-FR to fr`() {
        assertEquals("fr", WhisperLanguage.fromLanguageTag("fr-FR"))
    }

    @Test
    fun `fromLanguageTag maps es-ES to es`() {
        assertEquals("es", WhisperLanguage.fromLanguageTag("es-ES"))
    }

    @Test
    fun `fromLanguageTag maps it-IT to it`() {
        assertEquals("it", WhisperLanguage.fromLanguageTag("it-IT"))
    }

    @Test
    fun `fromLanguageTag maps pt-BR to pt`() {
        assertEquals("pt", WhisperLanguage.fromLanguageTag("pt-BR"))
    }

    @Test
    fun `fromLanguageTag maps nl-NL to nl`() {
        assertEquals("nl", WhisperLanguage.fromLanguageTag("nl-NL"))
    }

    @Test
    fun `fromLanguageTag maps ru-RU to ru`() {
        assertEquals("ru", WhisperLanguage.fromLanguageTag("ru-RU"))
    }

    @Test
    fun `fromLanguageTag maps uk-UA to uk`() {
        assertEquals("uk", WhisperLanguage.fromLanguageTag("uk-UA"))
    }

    @Test
    fun `fromLanguageTag maps pl-PL to pl`() {
        assertEquals("pl", WhisperLanguage.fromLanguageTag("pl-PL"))
    }

    @Test
    fun `fromLanguageTag maps tr-TR to tr`() {
        assertEquals("tr", WhisperLanguage.fromLanguageTag("tr-TR"))
    }

    @Test
    fun `fromLanguageTag maps ar-SA to ar`() {
        assertEquals("ar", WhisperLanguage.fromLanguageTag("ar-SA"))
    }

    @Test
    fun `fromLanguageTag maps hi-IN to hi`() {
        assertEquals("hi", WhisperLanguage.fromLanguageTag("hi-IN"))
    }

    @Test
    fun `fromLanguageTag maps zh-CN to zh`() {
        assertEquals("zh", WhisperLanguage.fromLanguageTag("zh-CN"))
    }

    @Test
    fun `fromLanguageTag maps ja-JP to ja`() {
        assertEquals("ja", WhisperLanguage.fromLanguageTag("ja-JP"))
    }

    @Test
    fun `fromLanguageTag maps ko-KR to ko`() {
        assertEquals("ko", WhisperLanguage.fromLanguageTag("ko-KR"))
    }

    @Test
    fun `fromLanguageTag maps bare de to de`() {
        assertEquals("de", WhisperLanguage.fromLanguageTag("de"))
    }

    @Test
    fun `fromLanguageTag maps bare en to en`() {
        assertEquals("en", WhisperLanguage.fromLanguageTag("en"))
    }

    @Test
    fun `fromLanguageTag remaps legacy iw to he`() {
        assertEquals("he", WhisperLanguage.fromLanguageTag("iw"))
    }

    @Test
    fun `fromLanguageTag remaps legacy in to id`() {
        assertEquals("id", WhisperLanguage.fromLanguageTag("in"))
    }

    @Test
    fun `fromLanguageTag remaps legacy ji to yi`() {
        assertEquals("yi", WhisperLanguage.fromLanguageTag("ji"))
    }

    @Test
    fun `fromLanguageTag remaps nb to no`() {
        assertEquals("no", WhisperLanguage.fromLanguageTag("nb"))
    }

    @Test
    fun `fromLanguageTag remaps jv to jw`() {
        assertEquals("jw", WhisperLanguage.fromLanguageTag("jv"))
    }

    @Test
    fun `fromLanguageTag returns AUTO for unsupported language`() {
        assertEquals(WhisperLanguage.AUTO, WhisperLanguage.fromLanguageTag("xx"))
    }

    @Test
    fun `fromLanguageTag returns AUTO for unsupported BCP-47 tag`() {
        assertEquals(WhisperLanguage.AUTO, WhisperLanguage.fromLanguageTag("xx-XX"))
    }

    @Test
    fun `fromLanguageTag returns AUTO for unrecognizable input`() {
        assertEquals(WhisperLanguage.AUTO, WhisperLanguage.fromLanguageTag("not-a-language"))
    }

    @Test
    fun `displayName returns English name for de`() {
        assertEquals("German", WhisperLanguage.displayName("de"))
    }

    @Test
    fun `displayName returns English name for en`() {
        assertEquals("English", WhisperLanguage.displayName("en"))
    }

    @Test
    fun `displayName returns English name for zh`() {
        assertEquals("Chinese", WhisperLanguage.displayName("zh"))
    }

    @Test
    fun `displayName returns English name for ja`() {
        assertEquals("Japanese", WhisperLanguage.displayName("ja"))
    }

    @Test
    fun `displayName returns English name for ko`() {
        assertEquals("Korean", WhisperLanguage.displayName("ko"))
    }

    @Test
    fun `displayName returns English name for fr`() {
        assertEquals("French", WhisperLanguage.displayName("fr"))
    }

    @Test
    fun `displayName returns English name for es`() {
        assertEquals("Spanish", WhisperLanguage.displayName("es"))
    }

    @Test
    fun `displayName returns English name for it`() {
        assertEquals("Italian", WhisperLanguage.displayName("it"))
    }

    @Test
    fun `displayName returns English name for pt`() {
        assertEquals("Portuguese", WhisperLanguage.displayName("pt"))
    }

    @Test
    fun `displayName returns English name for nl`() {
        assertEquals("Dutch", WhisperLanguage.displayName("nl"))
    }

    @Test
    fun `displayName returns English name for ru`() {
        assertEquals("Russian", WhisperLanguage.displayName("ru"))
    }

    @Test
    fun `displayName returns English name for uk`() {
        assertEquals("Ukrainian", WhisperLanguage.displayName("uk"))
    }

    @Test
    fun `displayName returns English name for pl`() {
        assertEquals("Polish", WhisperLanguage.displayName("pl"))
    }

    @Test
    fun `displayName returns English name for tr`() {
        assertEquals("Turkish", WhisperLanguage.displayName("tr"))
    }

    @Test
    fun `displayName returns English name for ar`() {
        assertEquals("Arabic", WhisperLanguage.displayName("ar"))
    }

    @Test
    fun `displayName returns English name for hi`() {
        assertEquals("Hindi", WhisperLanguage.displayName("hi"))
    }

    @Test
    fun `displayName returns code for unknown code`() {
        assertEquals("zz", WhisperLanguage.displayName("zz"))
    }

    @Test
    fun `SELECTABLE contains all expected languages in order`() {
        val expected = listOf(
            "en", "de", "es", "fr", "it", "pt", "nl", "ru",
            "uk", "pl", "tr", "ar", "hi", "zh", "ja", "ko"
        )
        assertEquals(expected, WhisperLanguage.SELECTABLE)
    }

    @Test
    fun `all SELECTABLE languages round-trip through fromLanguageTag`() {
        for (code in WhisperLanguage.SELECTABLE) {
            assertEquals(code, WhisperLanguage.fromLanguageTag(code))
        }
    }

    @Test
    fun `AUTO constant is auto`() {
        assertEquals("auto", WhisperLanguage.AUTO)
    }
}
