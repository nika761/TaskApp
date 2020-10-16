package com.example.taskapp.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;

@Root(strict = false)
@Attribute(name = "rss", required = false)
public class Rss {

    public Rss() {
    }

    @Text(required = false)
    @Attribute(name = "version", required = false)
    private String _version;

    public String get_version() {
        return _version;
    }

    @Element(name = "channel", required = false)
    private Channel ChannelObject;

    public Channel getChannel() {
        return ChannelObject;
    }

    @Element(name = "channel", required = false)
    public static class Channel {

        public Channel() {
        }

        @Element(name = "title", required = false)
        private String title;

        private String link;
        private String description;
        private String language;

        @Element(name = "copyright", required = false)
        private String copyright;

        @Element(name = "pubDate", required = false)
        private String pubDate;

        private String lastBuildDate;
        private String managingEditor;
        private String webMaster;

        @Element(name = "item", required = false)
        private Item ItemObject;

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getDescription() {
            return description;
        }

        public String getLanguage() {
            return language;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getPubDate() {
            return pubDate;
        }

        public String getLastBuildDate() {
            return lastBuildDate;
        }

        public String getManagingEditor() {
            return managingEditor;
        }

        public String getWebMaster() {
            return webMaster;
        }

        public Item getItem() {
            return ItemObject;
        }

    }

    @Element(name = "item", required = false)
    public static class Item {

        @Element(name = "title", required = false)
        private String title;

        private String link;

        @Element(name = "description", required = false)
        private String description;

        private String pubDate;
        private String guid;

        public Item() {
        }

        public String getTitle() {
            return title;
        }

        public String getLink() {
            return link;
        }

        public String getDescription() {
            return description;
        }

        public String getPubDate() {
            return pubDate;
        }

        public String getGuid() {
            return guid;
        }

    }

}



