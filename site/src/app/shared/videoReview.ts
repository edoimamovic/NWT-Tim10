export class VideoReview {
    public id: number;
    public reviewText: string;
    public reviewerUsername: string;
    public date: Date;
    public rating: number;

    constructor(data) {
        if (data) {
            this.id = data.id;
            this.reviewText = data.reviewText;
            this.reviewerUsername = data.reviewerUsername;
            this.date = data.date;
            this.rating = data.rating;
        }
    }
}
