export class Show {
    public id: number;
    public title: string;
;
  constructor(data) {
        if (data) {
            this.id = data.id;
            this.title = data.title;
        }
    }
}
