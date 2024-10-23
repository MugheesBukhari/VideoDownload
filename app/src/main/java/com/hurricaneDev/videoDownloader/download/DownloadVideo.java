/*
 * Copyright (c) 2021.  Hurricane Development Studios
 */

package com.hurricaneDev.videoDownloader.download;

import java.io.Serializable;

public class DownloadVideo implements Serializable {
    public String size;
    public String type;
    public String link;
    public String name;
    public String page;
    public String website;
    public boolean chunked;
}
