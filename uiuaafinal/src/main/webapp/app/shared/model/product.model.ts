export interface IProduct {
  id?: string;
  productName?: string;
  productId?: string;
  price?: number;
}

export const defaultValue: Readonly<IProduct> = {};
