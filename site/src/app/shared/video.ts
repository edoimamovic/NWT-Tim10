export class Video {
    public id: number;
    public title: string;
    public uploadedBy: number;
    public uploadDate: Date;
    public videoData: object;
    public category: object;
    public url: string;
    public thumbnailUrl: string;
    public description: string;

    constructor(data) {
        if (data) {
            this.id = data.id;
            this.title = data.title;
            this.uploadedBy = data.uploadedBy;
            this.uploadDate = data.uploadDate;
            this.category = data.category;
            this.videoData = data.videoData;
            this.url = data.url;
            this.thumbnailUrl = data.thumbnailUrl;
            this.description = data.description;
        }
    }
}
