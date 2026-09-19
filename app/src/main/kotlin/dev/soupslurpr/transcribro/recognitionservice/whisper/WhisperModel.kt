package dev.soupslurpr.transcribro.recognitionservice.whisper

/**
 * Whisper models bundled as app assets.
 *
 * Only the tiny model is bundled. Other models can be used by downloading them (see
 * [WhisperModelDownload]) and importing them from the local file system; in that case the
 * model is referenced by an absolute file path rather than a [WhisperModel] entry.
 *
 * Both bundled and imported models must be multilingual GGML models. English-only (".en")
 * models would ignore any non-English language request.
 */
enum class WhisperModel(val assetPath: String, val displayName: String) {
    TINY("models/whisper/ggml-model-whisper-tiny-q4_0.bin", "Tiny Q4_0 (bundled)");

    companion object {
        val DEFAULT = TINY

        /**
         * True if [modelSpec] points to a model imported from the file system.
         * Imported models are copied into app-internal storage and referenced by an absolute
         * file path; bundled models use a relative asset path.
         */
        fun isCustom(modelSpec: String?): Boolean =
            modelSpec != null && modelSpec.startsWith("/")
    }
}
