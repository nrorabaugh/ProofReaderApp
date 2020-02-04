package com.proofreader.server.Entity;

public class Assignment {
        private int id;
        private String name;
        private int classId;
        private String description;

        public Assignment(int id, String name, String description, int classId) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.classId = classId;
        }

//    public static class Message {
//        private int id;
//        private int senderId;
//        private String content;
//        private int assignmentId;
//        private String eq;
//
//        public Message(int id, int senderId, String content, int assignmentId, String eq) {
//            this.id = id;
//            this.senderId = senderId;
//            this.content = content;
//            this.assignmentId = assignmentId;
//            this.eq = eq;
//        }
//
////        public Message() {
////        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public int getSenderId() {
//            return senderId;
//        }
//
//        public void setSenderId(int senderId) {
//            this.senderId = senderId;
//        }
//
//        public String getContent() {
//            return content;
//        }
//
//        public void setContent(String content) {
//            this.content = content;
//        }
//
//        public int getAssignmentId() {
//            return assignmentId;
//        }
//
//        public void setAssignmentId(int assignmentId) {
//            this.assignmentId = assignmentId;
//        }
//
//        public String getEq() {
//            return eq;
//        }
//
//        public void setEq(String eq) {
//            this.eq = eq;
//        }
//    }

        public Assignment() {}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getClassId() {
            return classId;
        }

        public void setClassId(int classId) {
            this.classId = classId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
}

