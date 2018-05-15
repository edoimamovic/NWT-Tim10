export class Video {
    public id: number;
    public title: string;
    public uploadedBy: number;
    public uploadDate: Date;
    public videoData: string;
    public url: string;
    public thumbnailUrl: string;

    constructor(data) {
        if (data) {
            this.id = data.id;
            this.title = data.title;
            this.uploadedBy = data.uploadedBy;
            this.uploadDate = data.uploadDate;
            this.videoData = data.videoData;
            this.url = data.url;
            this.thumbnailUrl = data.thumbnailUrl;
        }
    }
}
