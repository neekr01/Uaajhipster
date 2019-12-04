export interface IBook {
  id?: string;
  bookname?: string;
  bookprice?: number;
}

export const defaultValue: Readonly<IBook> = {};
