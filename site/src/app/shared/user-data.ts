import { Review } from './review';

export class UserData {
    id: number;
    firstName: string;
    lastName: string;
    birthDate: Date;
    email: string;
    password: string;
    isActive: boolean;
    role_id: number;
    reviews: Array<Review>;

    constructor(data) {
        if (data) {
            this.id = data.id;
            this.firstName = data.firstName;
            this.lastName = data.lastName;
            this.birthDate = data.birthDate;
            this.email = data.email;
            this.password = data.password;
            this.isActive = data.isActive;
            this.role_id = data.role_id;
            this.reviews = data.reviews ? data.reviews.map(x => new Review(x)) : null;
        }
    }
}
