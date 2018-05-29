import { VideoReview } from "./videoReview";

export class Video {
    public id: number;
    public title: string;
    public description: string;
    public uploadedBy: number;
    public uploadDate: Date;
    public videoData: object;
    public category: object;
    public url: string;
    public thumbnailUrl: string;
    public rating: number;
    public images: string[];
    public reviewList: VideoReview[];

    constructor(data) {
        if (data) {
            this.id = data.id;
            this.title = data.title;
            this.description = data.description;
            this.uploadedBy = data.uploadedBy;
            this.uploadDate = data.uploadDate;
            this.videoData = data.videoData;
            this.category = data.category;
            this.url = data.url;
            this.thumbnailUrl = data.thumbnailUrl;
            this.rating = data.rating;

            data.images.forEach(element => {
                this.images.push(element.imageUrl);
            });

            data.reviewList.forEach(element => {
                this.reviewList.push(new VideoReview(element));
            });
        }
    }
}
