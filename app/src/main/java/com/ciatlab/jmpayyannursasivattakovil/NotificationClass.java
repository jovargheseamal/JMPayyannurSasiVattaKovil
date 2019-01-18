package com.ciatlab.jmpayyannursasivattakovil;

    /**
     * Created by ADMIN on 29-04-2018.
     */

    public class NotificationClass {
        String id,Title,Date,Content;
        NotificationClass(String title, String date, String id,String content )
        {
            this.id=id;
            this.Title=title;
            this.Date=date;
            this.Content=content;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String content) {
            Content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String date) {
            Date = date;
        }
    }


