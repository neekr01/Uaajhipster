export interface ICar {
  id?: string;
  name?: string;
  model?: string;
  price?: number;
}

export const defaultValue: Readonly<ICar> = {};
