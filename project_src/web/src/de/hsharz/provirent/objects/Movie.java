/*
 * Created on 06.10.2004
 *
 * Copyright (c) 2004/2005, Remo Griesch/Stefan Forstner/Philipp Schneider
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * - Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of the Remo Griesch/Stefan Forstner/Philipp Schneider nor
 * the names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 */
package de.hsharz.provirent.objects;

import java.util.Calendar;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Philipp Schneider
 *
 */
public class Movie {

    private int movieId;

    private String title;

    private String description;

    private int runtime;

    private Set actors;

    private Set directors;

    private Set studios;

    private Set languages;

    private Set subtitles;

    private Set encoding;

    private Set audioTracks;

    private Set aspectRatio;

    private Calendar releaseDate;



    /**
     * @return Returns the movieId.
     */
    public int getMovieId() {
        return movieId;
    }
    /**
     * @param movieId The movieId to set.
     */
    public void setMovieId(final int movieId) {
        this.movieId = movieId;
    }
    /**
     * @return Returns the actors.
     */
    public Set getActors() {
        return actors;
    }
    /**
     * @param actors The actors to set.
     */
    public void setActors(final Set actors) {
        this.actors = actors;
    }
    /**
     * @return Returns the aspectRatio.
     */
    public Set getAspectRatio() {
        return aspectRatio;
    }
    /**
     * @param aspectRatio The aspectRatio to set.
     */
    public void setAspectRatio(final Set aspectRatio) {
        this.aspectRatio = aspectRatio;
    }
    /**
     * @return Returns the audioTracks.
     */
    public Set getAudioTracks() {
        return audioTracks;
    }
    /**
     * @param audioTracks The audioTracks to set.
     */
    public void setAudioTracks(final Set audioTracks) {
        this.audioTracks = audioTracks;
    }
    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description The description to set.
     */
    public void setDescription(final String description) {
        this.description = description;
    }
    /**
     * @return Returns the directors.
     */
    public Set getDirectors() {
        return directors;
    }
    /**
     * @param directors The directors to set.
     */
    public void setDirectors(final Set directors) {
        this.directors = directors;
    }
    /**
     * @return Returns the encoding.
     */
    public Set getEncoding() {
        return encoding;
    }
    /**
     * @param encoding The encoding to set.
     */
    public void setEncoding(final Set encoding) {
        this.encoding = encoding;
    }
    /**
     * @return Returns the languages.
     */
    public Set getLanguages() {
        return languages;
    }
    /**
     * @param languages The languages to set.
     */
    public void setLanguages(final Set languages) {
        this.languages = languages;
    }
    /**
     * @return Returns the releaseDate.
     */
    public Calendar getReleaseDate() {
        return releaseDate;
    }
    /**
     * @param releaseDate The releaseDate to set.
     */
    public void setReleaseDate(final Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }
    /**
     * @return Returns the runtime.
     */
    public int getRuntime() {
        return runtime;
    }
    /**
     * @param runtime The runtime to set.
     */
    public void setRuntime(final int runtime) {
        this.runtime = runtime;
    }
    /**
     * @return Returns the studios.
     */
    public Set getStudios() {
        return studios;
    }
    /**
     * @param studios The studios to set.
     */
    public void setStudios(final Set studios) {
        this.studios = studios;
    }
    /**
     * @return Returns the subtitles.
     */
    public Set getSubtitles() {
        return subtitles;
    }
    /**
     * @param subtitles The subtitles to set.
     */
    public void setSubtitles(final Set subtitles) {
        this.subtitles = subtitles;
    }
    /**
     * @return Returns the title.
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title The title to set.
     */
    public void setTitle(final String title) {
        this.title = title;
    }
    public String toString() {
        return new ToStringBuilder(this).
          append("movieId", movieId).
          append("title", title).
          append("description", description).
          append("actors", actors).
          append("directors", directors).
          append("studios", studios).
          append("languages", languages).
          append("subtitles", subtitles).
          append("encoding", encoding).
          append("audioTracks", audioTracks).
          append("aspectRatio", aspectRatio).
          append("releaseDate", releaseDate).
          toString();
      }
    
}
