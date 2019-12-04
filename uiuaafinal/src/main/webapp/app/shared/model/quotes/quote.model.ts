import { Moment } from 'moment';

export interface IQuote {
  id?: string;
  symbol?: string;
  price?: number;
  lastTrade?: Moment;
}

export const defaultValue: Readonly<IQuote> = {};
